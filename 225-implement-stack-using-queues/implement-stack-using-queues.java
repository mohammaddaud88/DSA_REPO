class MyStack {
    Queue<Integer> q1,q2;


    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

    }
    
    public void push(int x) {
        q2.offer(x);
        while(q1.size() >0){
            q2.offer(q1.poll());
        }

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
    }
    
    public int pop() {
        if(empty()) return -1;
        return q1.poll();
    }
    
    public int top() {
        if(empty()) return -1;
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */