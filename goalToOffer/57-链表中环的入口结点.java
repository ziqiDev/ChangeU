/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode head){
        if(head==null){
            return head;
        }
        ListNode pre = head;
        ListNode last = head;
        int count = 0;
        boolean hasLoop = false;
        while(last!=null&&last.next != null){
            pre = pre.next;
            last = last.next.next;
            if(pre == last){
                hasLoop = true;
                break;
            }
        }
        if(!hasLoop){
            return null;
        }
        while(last!=null&& last.next !=null){
                    last = last.next.next;
                    pre = pre.next;
                    count ++;
                    if(pre == last){
                        break;
                    }
                }
        if(count == 0){
            return head;
        }
        pre = head;
        last = head;
        while(count>0){
            count--;
            last = last.next;
        }
        while(pre!=last){
            pre = pre.next;
            last = last.next;
        }
        return pre;
    }
}
