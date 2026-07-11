package DSA.LinkedList;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode resultList = dummy;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        int carry=0;
        while(l1!=null || l2!=null){
            int rem=0;
            int sum = 0;
            sum+=carry;
            if(l1!=null){
                sum += l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum +=l2.val;
                l2=l2.next;
            }

            rem = sum%10;
            carry = sum/10;
            resultList.next = new ListNode(rem);
            resultList = resultList.next;
        }
        if(carry>0){
            ListNode listNode = new ListNode(carry);
            resultList.next=listNode;
        }

        return dummy.next;
    }
}
