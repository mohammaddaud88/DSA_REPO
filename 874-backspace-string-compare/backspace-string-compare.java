class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if(!stack1.empty())stack1.pop();
            } else {
                stack1.push(s.charAt(i));
            }
        }
        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(!stack2.empty()) stack2.pop();
            }else {
                stack2.push(t.charAt(i));
            }
        }
        if(stack1.size() != stack2.size()){
            return false;
        }
        while(stack1.empty() == false){
            if(stack1.peek() == stack2.peek()){
                stack1.pop();
                stack2.pop();
            }else {
                return false;
            }
        }
        return true;
    }
}