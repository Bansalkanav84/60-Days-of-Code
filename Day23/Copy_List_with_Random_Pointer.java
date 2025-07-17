class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
    // make copy of each node just after original
        Node node = head;
        while(node != null){      
            Node copy = new Node(node.val); // For A-> B it becomes A-> A'-> B-> B'
            copy.next = node.next;  // assign next of these clone nodes
            node.next = copy;
            node = copy.next;
        }

    // assign random of the clone nodes
        node = head;
        while(node != null){   
            if(node.random != null){      
              // suppouse A.random points to B , so A'.random should point to B'(which is infact B.next) 
                node.next.random = node.random.next;  // this means A'.random = B.next
            }
            node = node.next.next; 
        }

    // This part separates the cloned and the original LL
        node = head;
        Node pseudoHead = new Node(0);  // a dummy node for storing the cloned LL
        Node copy, copytail = pseudoHead; // these 2 will help us separate the cloned LL

        while(node != null){
            copy = node.next; // copy now points at A'
            copytail.next = copy; // basically pseudoHead now points to A'
            copytail = copy; // move copytail ahead , now at A'
        
        // below line helps us get the original LL
            node.next = copy.next; // this means A.next = A'.next, basically A->B
            node = node.next; // move node from A to B
        }
        return pseudoHead.next; // return the cloned LL
    }
}