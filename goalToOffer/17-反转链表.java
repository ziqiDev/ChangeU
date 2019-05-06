/*
输入一个链表，反转链表后，输出新链表的表头。
*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode current = head;
        while(head !=null){
            current = head.next;
            if(pre.next ==null){
                pre.next = head;
                pre.next.next = null;
            }else{
                head.next = pre.next;
                pre.next = head;
            }
            head = current;
        }
        return pre.next;
    }
}
