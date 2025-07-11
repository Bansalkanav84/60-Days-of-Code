class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder st = new StringBuilder();
        while(head != null){
            st.append(head.val);
            head = head.next;
        }

        int n = st.length()-1;
        int val = 0;

        for(int i = 0; i<st.length(); i++){
            val += (st.charAt(i) - '0') * Math.pow(2,n);
            n--;
        }

        return val ;
    }
}