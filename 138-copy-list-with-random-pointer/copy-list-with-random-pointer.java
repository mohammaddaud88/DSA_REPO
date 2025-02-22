/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr=head;
        while(curr != null){
            curr.next.random = curr.random == null ? null : curr.random.next;
            curr=curr.next.next;
        }
        Node node = head.next;
        curr = head;
        while(curr!=null){
            Node originalNext = curr.next.next;
            Node copyNode = curr.next;
            copyNode.next = originalNext == null?null:originalNext.next;
            
            curr.next = originalNext;
            curr = originalNext;

        }
        return node;
    }
}