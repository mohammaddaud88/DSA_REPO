class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (sum.containsKey(val)) {
                return new int[] { i, sum.get(val) };
            }
            sum.put(nums[i], i);
        }

        return new int[] { -1, -1 };

    }
}