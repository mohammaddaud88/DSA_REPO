class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(getMaxRob(nums,0,nums.length-2),getMaxRob(nums,1,nums.length-1));
    }
    public int getMaxRob(int arr[], int s, int e){
        int prevRob =0;
        int maxRob = 0;
        for(int i=s;i<=e;i++){
            int temp = Math.max(maxRob,prevRob + arr[i]);
            prevRob = maxRob;
            maxRob = temp;
        }
        return maxRob;
    }
}