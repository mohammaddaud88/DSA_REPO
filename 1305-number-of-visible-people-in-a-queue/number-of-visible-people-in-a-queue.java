class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[n];
        for(int i =n-1;i>=0;i--){
            int count=0;
            while(st.size()>0 && st.peek() <= heights[i]){
                st.pop();
                count++;
            }
            if(st.size() > 0){
                count++;
            }
            ans[i]=count;
            st.push(heights[i]);
        }
        return ans;
    }
}