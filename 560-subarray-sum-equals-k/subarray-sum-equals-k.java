class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix[] = new int [nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            int req = prefix[i]-k;
            count += map.getOrDefault(req,0);
            int currFreq = map.getOrDefault(prefix[i],0);
            map.put(prefix[i],currFreq+1);
        }

        return count;
        // int count=0;
        // for(int i=0;i<nums.length;i++){
        // int sum=0;
        // for(int j=i;j<nums.length;j++){
        // sum += nums[j];
        // if(sum == k){
        // count++;
        // }
        // }
        // }
        // return count;
    }
}