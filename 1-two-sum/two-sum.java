class Solution {
    public int[] twoSum(int[] nums, int target) {
    //     Map<Integer,Integer> arr = new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         int sub = target-nums[i];
    //         if(arr.containsKey(sub)){
    //             return new int []{i,arr.get(sub)};
    //         }
    //         arr.put(nums[i],i);
    //     }
    //     return new int []{-1,-1};
    
        Map<Integer, Integer> pairIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (pairIdx.containsKey(target - num)) {
                return new int[] { i, pairIdx.get(target - num) };
            }
            pairIdx.put(num, i);
        }

        return new int[] {}; 

    }
}