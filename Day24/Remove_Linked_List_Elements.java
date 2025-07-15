class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(0);  // create a dummy node
        ListNode curr = dummy;
        dummy.next = head;
        while(curr != null && curr.next != null){ 
            if(curr.next.val == val){         // if match found, skip the next node
                curr.next = curr.next.next;   
            }
            else{
            curr = curr.next;   // else move to the next node
            }
        }
        return dummy.next;
    }
}