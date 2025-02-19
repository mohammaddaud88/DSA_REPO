class Solution {
    public int findPairs(int[] nums, int k) {
        int count =0;
        int j=0;
        int n = nums.length;
        Arrays.sort(nums);
        // for(int i=0;i<n;i++){
        //     while(j<n && nums[j]-nums[i] <k){
        //         j++;
        //     }
        //     if(j<n && nums[j]-nums[i] == k && i != j){
        //         count++;
        //         while(j+1<n && nums[j] == nums[j+1]){
        //             j++;
        //         }
        //         j++;
        //     }
        // }

        int i=0;
        j=0;
        
        while(i<n && j<n){
            if(j<n && nums[j]-nums[i] == k && i!= j){
                count++;
                while(j+1<n && nums[j]== nums[j+1]){
                    j++;
                }
                j++;
            } else if(nums[j]-nums[i] > k){
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}