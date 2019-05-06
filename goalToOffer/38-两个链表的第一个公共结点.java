/*
输入两个链表，找出它们的第一个公共结点。
*/
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
         if(pHead1 == null||pHead2==null){
             return null;
         }
         int length1 = 0;
        int length2 = 0;
         ListNode  head = pHead1;
        while(head!=null){
            length1++;
            head = head.next;
        }
        head = pHead2;
        while(head!=null){
            length2++;
            head = head.next;
        }
        while(length1>length2){
            length1--;
            pHead1 = pHead1.next;
        }
        while(length1<length2){
            length2--;
            pHead2 = pHead2.next;
        }
        while(pHead1 !=null&&pHead1.val !=pHead2.val){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }
}
