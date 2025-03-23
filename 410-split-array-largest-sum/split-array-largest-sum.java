class Solution {
    public int splitArray(int[] nums, int k) {
        // for(int i=1;i<nums.length;i++){
        //     nums[i] += nums[i-1];
        // }
        int i=0;
        int j = (int) 1e9;
        int ans =-1;
        while(i<=j){
            int mid = i + (j-i)/2;
            if(isPossible(nums,mid,k)){
                ans = mid;
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int [] nums, int mid, int k){
        int part = 1;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > mid){
                return false;
            } else if(sum + nums[i] <=mid){
                sum += nums[i];
            } else{
                sum = nums[i];
                part++;
            }
        }
        return part <= k;
    }
}