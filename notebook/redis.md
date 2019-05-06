# redis总结

## redis的主要数据结构
	String
	链表
		实现Redis的各种功能，比如列表键，发布与订阅，满查询，监视器等;链表实现为双端链表，无环链表
	字典
		实现redis的各种功能，包括数据库和哈希键；字典使用哈希表作为底层实现，每个字典有两个哈希表，一个平时使用，另一个仅在rehash时使用
	跳跃表
		有序集合的底层实现之一，由zskiplist 和zskipNode两个结构组成，其中zskiplist用于保存跳跃表信息（表头节点，表尾节点，长度），zskipNode用于表示跳跃表节点
	整数集合
		整数集合是集合键的底层实现之一，升级操作为整数集合带了操作上的灵活性并节约了内存；只支持升级，不支持降级
	压缩列表
		列表键和哈希键的底层实现之一，为节约内存而开发的顺序型数据结构

## redis中的对象
		Redis的对象系统实现了基于引用计数技术的内存回收机制，当程序不再使用某个对象的时候，这个对象所占用的内存就会被自动释放；另外，Redis还通过引用计数技术实现了对象共享机制，这一机制可以在适当的条件下，通过让多个数据库键共享同一个对象来节约内存。
		1. 字符串对象（String）
			字符串对象编码类型：int, raw, embstr
			整数 -> int 
			字符串 （<32字节):embstr (>32字节)：raw

		2. 列表对象（List）
			列表对象的编码是ziplist或者linkedlist
				ziplist使用压缩列表作为底层实现；linkedlist使用链表作为底层实现
			列表对象同时满足以下条件时，使用ziplist编码，否则使用linkedlist
				1. 列表对象保存的所有字符串元素都小于64字节  // 可通过配置list-max-ziplist-value 调整
				2. 列表对象保存的元素数量小于512个			// 可通过配置list-max-ziplist-entries 调整

		3. 哈希对象（Hash）
			哈希对象的编码是ziplist或者hashtable
				ziplist使用压缩列表作为底层实现；hashtable编码的hash对象使用字典作为底层实现
			哈希对象同时满足以下两个条件时，哈希对象使用ziplist编码，否则使用hashtable编码
				1. 哈希对象保存的所有键值对的键和值的字符串长度都小于64字节  // 可通过配置hash-max-ziplist-value 调整
				2. 哈希对象保存的键值对数量小于512个					  // 可通过配置hash-max-ziplist-entries 调整

		4. 集合对象（Set）
			集合对象的编码是intset 或者hashtable
				intset使用整数集合作为底层实现；hashtable编码的集合对象使用字典作为底层实现
			集合对象同时满足以下条件时，对象使用intset编码,否则使用hashtable编码
				1. 集合对象保存的所有元素都是整数值
				2. 集合对象保存的元素数量不超过512个   					//	 可通过配置set-max-intset-entries调整

		5. 有序集合对象（Zset）
			有序集合的编码可以时ziplist或者skiplist
				ziplist使用压缩列表作为底层实现；skiplist编码的有序集合对象使用zset结构作为底层实现，zset结构同时包含一个字典和一个跳跃表，利用了跳跃表的有序和字典的查找成员
			有序集合对象同时满足以下两个条件时，对象使用ziplist编码：
				1. 有序集合保存的元素数量小于128个						// 可通过配置zset-max-ziplist-entries调整
				2. 有序集合保存的所有元素成员的长度都小于64字节		 	// 可通过配置zset-max-ziplist-value调整

		Redis的对象共享
			1.redis会共享值为0-9999的字符串对象，验证操作的时间复杂度为O(1)
			2.redis不共享其他字符串对象, 验证操作的时间复杂度为O(N)



## redis中三种特殊的数据类型
	1. bitMap
		通过一个bit位开表示某个元素对应的值或状态
		
		常用命令
			1. setbit key offset value  // 设置字符串的值
			2. getbit ket offset // 获取字符串偏移量的值
			3. bitcount key [start] [end]   // 计算字符串中被设置为1的数量
			4. bitop and  desckey key [key...]  // 多个值求逻辑并
			5. bitop or  desckey key [key...]   // 多个值求逻辑或
			6. bitop xor  desckey key [key...]  // 多个值求逻辑异或
			7. bitop not  desckey key 			// 多个值求逻辑非
			8. bitpos key bit [start] [end] //返回字符串中第一个值为1的位置
			9. bitfield 

	2. Geo 地理位置信息
		常用命令
			1. geoadd key longitude latitude member //将给定的空间元素（纬度，经度，名字）添加到指定的键里
			2. geopos key member //返回所有给定位置元素的位置
			3. geodist key members1 member2 [unit]//返回两个位置之间的距离
			4. georadius key lingitude latitude radius unit //以给定位置位中心的，radius 为半径的内的所有元素
			5. georadiusbymember key member radius unit //基本同georadius
			6. geohash key member // 返回一个位置元素的geohash表示

	3. HyperLogLog 基数统计
		常用命令
			1. pfadd key element [element...] // 添加元素到hyperloglog
			2. pfcount key [key...]// 统计元素内的近似数量
			3. pfmerge destkey sourcekey [sourcekey...] 合并多个key


## redis 数据淘汰机制
		当maxmemory限制达到的时候Redis会使用的行为由 Redis的maxmemory-policy配置指令来进行配置。
		以下的策略是可用的:
		noeviction:返回错误当内存限制达到并且客户端尝试执行会让更多内存被使用的命令（大部分的写入指令，但DEL和几个例外）
		allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。
		volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。
		allkeys-random: 回收随机的键使得新添加的数据有空间存放。
		volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。
		volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。

		allkeys-lru 和 volatile-random策略对于当你想要单一的实例实现缓存及持久化一些键时很有用。不过一般运行两个实例是解决这个问题的更好方法。
		为了键设置过期时间也是需要消耗内存的，所以使用allkeys-lru这种策略更加高效，因为没有必要为键取设置过期时间当内存有压力时。

## redis 数据过期处理原理·
		1. 定时删除：在设置键的过期时间的同时，创建一个定时器（timer），让定时器在键的过期时间来临时，立即执行对键的删除操作。 
			内存友好，cpu不友好
		2. 惰性删除：放任键过期不管，但是每次从键空间中获取键时，都检查取得的键是否过期，如果过期的话，就删除该键；如果没有过期，就返回该键。 
			cpu友好，内存不友好
		3. 定期删除：每隔一段时间，程序就对数据库进行一次检查，删除里面的过期键。至于要删除多少过期键，以及要检查多少个数据库，则由算法决定。
			定时删除和惰性删除的折中方案，难点是确定删除操作执行的时长和频率
		
		redis 采取的方案是惰性删除和定期删除的折中

## redis 持久化方案
		持久化方案有两种：AOF持久化 和 RDB持久化
		RDB持久化 （保存数据库状态来持久化）
			RDB文件用于保存和还原Redis服务器所有数据库中的所有键值对数据
			RDB文件是一个经过压缩的二进制文件，由多个部分组成。
			对于不同类型的键值对，RDB文件会使用不同的方式来保存它们
		配置：
			满足三个条件中的任意一个，bgsave命令就会被执行
			// 900秒（15分钟）内至少1个key值改变
			// 300秒（5分钟）内至少10个key值改变
			// 60秒（1分钟）内至少10000个key值改变
			save 900 1
			save 300 10
			save 60 10000
		AOF持久化 （保存数据库的写命令来记录数据库状态）
			1. AOF文件中的所有命令都以Redis命令请求协议的格式保存。
			2. 命令请求会先保存到AOF缓冲区里面，之后再定期写入并同步到AOF文件
			3. appendfsync选项的不同值对AOF持久化功能的安全性以及Redis服务器的性能有很大的影响。 
			4. bgrewriteaof，该功能是通过读取数据库中的键值对来实现的，程序无须对现有AOF文件进行任何读入、分析或者写入操作
			5. 在执行BGREWRITEAOF命令时，Redis服务器会维护一个AOF重写缓冲区，该缓冲区会在子进程创建新AOF文件期间，记录服务器执行的所有写命令。当子进程完成创建新AOF文件的工作之后，服务器会将重写缓冲区中的所有内容追加到新AOF文件的末尾，使得新旧两个AOF文件所保存的数据库状态一致。最后，服务器用新的AOF文件替换旧的AOF文件，以此来完成AOF文件重写操作
		配置：
			appendfsync always //每次有数据修改都会写入AOF文件，这样会严重降低redis性能
			appendfsync everysec //每秒钟同步一次
			appendfsync no  //由操作系统控制


## redis 缓存击穿，缓存雪崩，缓存穿透，缓存预热
		缓存击穿
			对于一些设置了过期时间的key，缓存在某个时间点过期的时候，恰好这个key有大量的并发请求过来，大并发请求可能瞬间把后端DB压垮。与缓存雪崩不同的点是这个是一个的key缓存

		缓存雪崩
			如果缓存挂掉，所有的请求都会打到数据库上，如果没有提前进行容量预估，可能会把数据库压垮，导致系统整体不可用
			解决办法：
				1. 使用互斥锁，setexnx 操作成功在load db
				2. 分析用户行为，让失效时间均匀分布
				3. 多级缓存

		缓存穿透
			使用不存在的key进行大量高并发查询，导致缓存无法命中
			解决办法：
				1. 使用布隆过滤器，将所有可能存在的数据哈希到一个足够大的bitmap 中，不存在的数据可以被bitmap拦截
				2. 将空结果短时间(不超过5分钟)缓存。

		缓存预热
			系统上线后，提前将相关的缓存数据直接加载到缓存系统
			解决方法：
				1. 系统启动时加载
				2. 新建缓存刷新页面，上线时手动刷新


## redis 缓存和数据库双写的数据一致性问题
		淘汰缓存是一种通用的缓存处理方式
		先淘汰缓存，再写数据库
		

## redis 的一些问题
	redis 是单进程单线程运行的。
	为什么不使用多线程？
		1.单线程性能已经足够好了
		2.避免多线程对资源的竞争，以及上下文切换
	redis 什么时候不是单进程
		1. 使用了命令bgsave和bgrewriteaof

	线上应该redis应该避免哪些问题？
		1. 避免使用save 命令，优先使用bgsave
			SAVE命令会阻塞Redis服务器进程，直到RDB文件创建完毕为止，在服务器进程阻塞期间，服务器不能处理任何命令请求
			BGSAVE命令会派生出一个子进程，然后由子进程负责创建RDB文件，服务器进程（父进程）继续处理命令请求
		2. 禁用keys, flushall, flushdb等命令,通过rename机制禁掉命令


## redis 监控
		当一个客户端从普通客户端变为监视器时，该客户端的REDIS_MONITOR标识会被打开。服务器将所有监视器都记录在monitors链表中。每次处理命令请求时，服务器都会遍历monitors链表，将相关信息发送给监视器。

###### 参考文献
	https://juejin.im/entry/5babfe59e51d450e8c34f8b9
	黄健宏 著. Redis设计与实现 (数据库技术丛书)

