class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(text1.length(),text2.length(),text1,text2);
    }
    int helper(int m, int n, String s1,String s2){
        if(m == 0 || n==0){
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int ans = 0;
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            ans = 1+ helper(m-1,n-1,s1,s2);
        } else {
            int a = helper(m-1,n,s1,s2);
            int b = helper(m,n-1,s1,s2);
            ans = Math.max(a,b);
        }
        dp[m][n]=ans;
        return ans;
    }
}