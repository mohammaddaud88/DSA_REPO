class Solution {
    public int countKDifference(int[] nums, int k) {
        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int count = map.getOrDefault(nums[i],0);
            map.put(nums[i],count+1);
        }
        for(int i=0;i<nums.length;i++){
            ans += map.getOrDefault(nums[i]-k,0)+map.getOrDefault(nums[i]+k,0);
        }
        return ans/2;
    }
}