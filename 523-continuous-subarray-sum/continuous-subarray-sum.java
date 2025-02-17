class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length;
        // int prefixSum [] = new int[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        int pSum = 0;
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            // prefixSum[i] += prefixSum[i-1]+nums[i-1];
            pSum += nums[i];

            int rem = pSum % k;
            if (map.containsKey(rem)) {
                if ((i - map.get(rem)) > 1) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }

       
        // for(int i=0;i<n-1;i++){
        // for(int j=i+1;j<n;j++){
        // if(prefixSum[j+1] - prefixSum[i] == 0 && k ==0){
        // return true;
        // }
        // if((prefixSum[j+1] - prefixSum[i]) %k ==0 && k!=0){
        // return true;
        // }
        // }
        // }

        return false;
    }
}