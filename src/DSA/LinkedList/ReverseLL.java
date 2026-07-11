package DSA.LinkedList;

public class ReverseLL {

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode curr = head;
        ListNode prev=null ;
        ListNode temp=null;

        while(curr!=null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;

        return head;

    }
}
