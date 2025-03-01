class Solution {
    public int rob(int[] nums) {
         if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int [] max_loot = new int[nums.length];
        max_loot[0] = nums[0];
        max_loot[1]= Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            max_loot[i] = Math.max(max_loot[i-2]+nums[i],max_loot[i-1]);
        }

        return max_loot[nums.length-1];
    }
}