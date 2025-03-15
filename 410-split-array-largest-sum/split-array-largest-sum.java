class Solution {
    public int splitArray(int[] nums, int k) {
        long low =0;
        long high = (int) 1e9;
        long ans =high;
        while(low<=high){
            long mid = low + (high -low)/2;
            if(isPossible(nums,mid,k)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return (int) ans;
    }
    public boolean isPossible(int [] nums, long target, long maxPart){
        long part = 1;
        long sum =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] > target){
                return false;
            } else if(nums[i] + sum <= target){
                sum += nums[i];
            } else {
                part++;
                sum = nums[i];
            }
        }
        return part <= maxPart;
    }
}