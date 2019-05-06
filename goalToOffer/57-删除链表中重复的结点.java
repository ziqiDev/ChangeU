/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*/
public class Solution {
    public ListNode deleteDuplication(ListNode head)
    {
        if(head == null){
            return head;
        }
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        ListNode current = preNode;
        int last = -1;
        while(current.next!=null){
            ListNode temp = current.next;
            last = temp.val;
            if(temp.next!=null&& temp.next.val == last){
                while(temp.next!=null&& temp.next.val == last){
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = null;

            }else{
                current = current.next;
            }
        }
        return preNode.next;
    }
}
