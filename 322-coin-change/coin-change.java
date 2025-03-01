class Solution {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        dp  = new int[amount+1];
        Arrays.fill(dp,-1);
       int ans = helper(amount,coins);
       return ans>amount ? -1:ans;
    }
    int helper(int amount, int coins[]){
        
       if(amount == 0){
            return 0;
        }
        if(dp[amount] != -1){
            return dp[amount];
        }
        int ans =(int) 1e9;
        for(int x:coins){
            if(x<=amount){
                ans= Math.min(ans,helper(amount-x,coins)+1);
            }
        }
        dp[amount]=ans;
        return ans;
    }
}