class Solution {
    public String removeKdigits(String num, int k) {
        // int val = Integer.parseInt(num);
        StringBuilder sb = new StringBuilder();

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (st.size() > 0 && st.peek() > num.charAt(i) && k > 0) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }

        while(st.size() >0 && k>0){
            st.pop();
            k--;
        }
        while (st.size() > 0) {
            sb.append(st.peek());
            st.pop();
        }
        
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.reverse();
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}