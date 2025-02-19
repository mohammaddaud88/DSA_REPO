class Solution {
    public int search(int[] nums, int target) {
        int i;
        int j;
        int pivot = findPivot(nums);
        if(nums[0] <= target && nums[pivot] >= target){
            i=0;
            j=pivot;
        } else {
            i=pivot+1;
            j= nums.length-1;
        }
        while(i<=j){
            int mid = (i + j)/2;
            if(nums[mid] < target){
                i = mid+1;
            } else if(nums[mid] > target){
                j=mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public int findPivot(int nums[]){
        int low=0;
        int high = nums.length-1;
        int ans=90;
        while(low <= high){
            int mid = (low+ high)/2;
            if(nums[mid] >= nums[0] ){
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
}