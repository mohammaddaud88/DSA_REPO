class Solution {
    public int[] searchRange(int[] nums, int target) {
            int res[] = {-1,-1};
            int l=0;
            int r=nums.length-1;
            int ans = -1;

            while(l<=r){
                int m= (l+r)/2;
                if(nums[m] < target){
                    l=m+1;
                } else if(nums[m] > target){
                    r= m-1;
                } else {
                    ans = m;
                    r=m-1;
                }
            }
            res[0]=ans;
            l=0;
            r=nums.length-1;
            ans=-1;
            while(l<=r){
                int m = (l+r)/2;
                if(nums[m] < target){
                    l = m+1;
                } else if(nums[m] > target){
                    r= m-1;
                } else {
                    ans = m;
                    l=m+1;
                }
            }
            res[1]=ans;
            return res;
        }


    // int left = findPos(nums,target,true);
    // int right = findPos(nums,target,false);
    // return new int []{left,right};
    // }
    // public int findPos(int nums[], int target, boolean isStart){
    // int left=0;
    // int right = nums.length-1;
    // int ans =-1;

    // while(left <=right){
    // int mid = (left+right)/2;
    // if(nums[mid] == target){
    // ans = mid;
    // if(isStart){
    // right = mid-1;
    // } else {
    // left = mid+1;
    // }
    // } else if(nums[mid] > target){
    // right = mid-1;
    // } else {
    // left = mid+1;
    // }
    // }
    // return ans;
// }
}