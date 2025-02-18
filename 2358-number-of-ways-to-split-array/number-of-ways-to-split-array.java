class Solution {
    public int waysToSplitArray(int[] nums) {
        int count=0;
        long currSum =0;
        long totalSum =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        for(int i=0;i<n-1;i++){
            currSum += nums[i];
            if(currSum >= totalSum - currSum){
                count++;
            }
        }

        // int n = nums.length-1;
        // for(int i=1;i<=n;i++){
        //     nums[i] += nums[i-1];
        // }
        // for(int i=0;i<n;i++){
        //     if(nums[i] >= nums[n]-nums[i]){
        //         count++;
        //     }
        // }
        return count;
    }
}