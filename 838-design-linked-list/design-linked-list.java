class Node{
        Node next;
        int value;
        public Node(int value){
            this.value=value;
            this.next=null;
        }
        public Node(Node next, int value){
            this.next = next;
            this.value=value;
        }

    }
class MyLinkedList {
    
    Node head;

    public MyLinkedList() {
       head=null;
    }
    public Node findNode(int pos){
        Node curr = head;
        int count=0;
        while(count != pos && curr != null){
            curr = curr.next;
            count++;
        }
        return curr;
    }
    
    public int get(int index) {
        Node node=findNode(index);
        if(node != null){
            return node.value;
        }
        
        return -1;
    }
    
    public void addAtHead(int val) {
        Node node=new Node(val);
        node.next=head;
        head=node;
        
    }
    
    public void addAtTail(int val) {
        if(head == null){
            addAtHead(val);
            return;
        }
        Node node= new Node(val);
        Node curr = head;
        while(curr.next != null){
            curr=curr.next;
        }
        curr.next = node;
        
    }
    
    public void addAtIndex(int index, int val) {
        int len = getLength();
        if(index < 0 || index > len){
            return;
        }
        if(index == 0){
            addAtHead(val);
            return;
        }
        

        Node node = findNode(index-1);
        Node newNode = new Node(val);
        newNode.next = node.next;
        node.next=newNode;
        
    }

    private void deleteHead(){
        if(head == null){
            return;
        }
        head = head.next;
    }
    
    public void deleteAtIndex(int index) {
        int len = getLength();
        if(index < 0 || index >= len){
            return;
        }
        if(index == 0){
            deleteHead();
            return;
        } 
        Node prevNode = findNode(index-1);
        prevNode.next = prevNode.next.next;
        
    }
    public int getLength(){
        Node curr = head;
        int size=0;
        while(curr != null){
            curr=curr.next;
            size++;
        }
        return size;
    }
    
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */