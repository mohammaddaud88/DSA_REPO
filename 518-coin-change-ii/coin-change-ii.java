class Solution {
    int dp[][];
    int count=0;
    public int change(int amount, int[] coins) {
        dp = new int[amount+1][coins.length+1];
        for(int i=0;i<amount+1;i++){
            Arrays.fill(dp[i],-1);
        }
        int m = coins.length;
        return solve(amount,m,coins);
    }
    int solve(int amount,int len, int [] coins){
        if(len ==0 || amount<0){
            return 0;
        }
        if(amount == 0){
            return 1;
        }
        if(dp[amount][len] != -1){
            return dp[amount][len];
        }
        int takeIt = solve(amount-coins[len-1],len,coins);
        int dontTake = solve(amount,len-1,coins);

        int ans = takeIt + dontTake;
        dp[amount][len]=ans;
        return ans;
    }
}