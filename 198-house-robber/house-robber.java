class Solution {
    int dp[];
    public int rob(int[] nums) {
        dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1);
    }
    int helper(int [] nums, int n){
        if(n==0){
            return nums[n];
        }
        if(n<0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        
        int take = nums[n]+ helper(nums,n-2);
        int dontTake = helper(nums,n-1);
        dp[n]= Math.max(take,dontTake);
        return Math.max(take,dontTake);
    }
}