class Node{
    Node next;
    Node prev;
    int freq;
    HashSet<String> set;
    public Node(int freq){
        this.freq = freq;
        this.next=null;
        this.prev=null;
        set = new HashSet<>();
    }
}

class AllOne {
    HashMap<String,Node> keyMap;
    // HashMap<Integer,Node> freqMap;
    Node head;
    Node tail;

    public AllOne() {
        keyMap = new HashMap<>();
        // nodeMap = new HashMap<>();
        this.head = new Node(0);
        this.tail = new Node((int) 1e9);
        head.next = tail;
        tail.prev = head;
    }


    public void addNodeAfter(Node node){
        Node newNode = new Node(node.freq+1);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next  = newNode;
    }

    public void deleteNode(Node node){
        if(node.freq == 0){
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    public void addNodeBefore(Node node){
        Node newNode = new Node(node.freq-1);
        newNode.next = node;
        newNode.prev = node.prev;

        node.prev.next = newNode;
        node.prev = newNode;

    }
    
    public void inc(String key) {
        Node currNode;
        int currFreq;
        if(keyMap.containsKey(key)){
            currNode = keyMap.get(key);
            currFreq = currNode.freq;
            currNode.set.remove(key);
        }else{
            currNode= head;
            currFreq=0;
        }
        if(currNode.next.freq != currFreq+1){
            addNodeAfter(currNode);
        }
        Node newNode = currNode.next;
        newNode.set.add(key);
        keyMap.put(key,newNode);

        // now we are checking that if currNode is empty such that no key is available
        if(currNode.set.isEmpty()){
            deleteNode(currNode);
        }
    }
    
    public void dec(String key) {

        // if(!keyMap.containsKey(key)) return;
        Node currNode;
        int currFreq;

        if(keyMap.containsKey(key)){
            currNode = keyMap.get(key);
            currFreq = keyMap.get(key).freq;
            currNode.set.remove(key);
        } else {
            currNode = head;
            currFreq=0;
        }

        if(currFreq-1 != currNode.prev.freq){
            addNodeBefore(currNode);
        }

        Node newFreqNode = currNode.prev;
        newFreqNode.set.add(key);
        keyMap.put(key,currNode.prev);

        if(currNode.set.size() == 0){
            deleteNode(currNode);
        }
        
    }
    
    public String getMaxKey() {
        if(tail.prev == head){
            return "";
        }
        return tail.prev.set.stream().findFirst().get();
    }
    
    public String getMinKey() {
        if(tail.prev == head){
            return "";
        }
        return head.next.set.stream().findFirst().get();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */