
/*
输入一个链表，输出该链表中倒数第k个结点。
*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head ==null||k<=0){
            return null;
        }
        int length = 0;
        ListNode currentNode = head;
        while(currentNode !=null){
            currentNode = currentNode.next;
            length++;
        }
        if(length < k){
            return null;
        }
        currentNode =head;
        while(k>1){
            k--;
            currentNode = currentNode.next;
        }
        while(currentNode.next!=null){
            head = head.next;
            currentNode = currentNode.next;
        }
        return head;
    }
}
