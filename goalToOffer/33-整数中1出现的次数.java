/*

求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
*/
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int level = 1;
        int current =0, before =0, after = 0;
        while((n/level) !=0){
            after = n%level;
            before = n/(10* level);
            current = (n/level)%10;
            if(current ==0){
                count = count + before*level;
            }else if(current ==1){
                count = count+ before *level +1 +after;
            }else{
                count = count + (before+1)* level;
            }
            level *= 10;
        }
        return count;
    }
}
