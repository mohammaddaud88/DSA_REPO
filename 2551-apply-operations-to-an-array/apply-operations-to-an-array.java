class Solution {
    public int[] applyOperations(int[] nums) {
        // int j=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
            // j++;
        }
        int j=0;
        int ans[]= new int[nums.length];
        Arrays.fill(ans,0);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[j]=nums[i];
                j++;
            }
        }
        return ans;
    }
}