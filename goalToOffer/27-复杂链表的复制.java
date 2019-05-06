/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode head)
    {
        if(head== null){
            return null;
        }
        RandomListNode pre = new RandomListNode(1);
        pre.next = head;
        while(head !=null){
            RandomListNode headCopy = new RandomListNode(head.label);
            headCopy.next = head.next;
            head.next = headCopy;
            head = headCopy.next;
        }
        head = pre.next;
        while(head != null){
            if(head.random !=null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = pre;
        while(head.next !=null){
            RandomListNode current = head.next;
            head.next = current.next;
             current.random = null;
            current.next = null;
            head = head.next;
        }
        return pre.next;
        
    }
}
