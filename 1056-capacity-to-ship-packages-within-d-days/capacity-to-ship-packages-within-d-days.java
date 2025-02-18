class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low =0;
        int high = (int) 1e8;
        int ans=-1;
        while(low<=high){
            int mid = low+(high -low)/2;
            if(isPossible(weights,mid,days)){
                ans=mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int [] arr, int target , int days){
        int day=1;
        int sum=0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i] > target){
                return false;
            } else if(arr[i]+sum <= target){
                sum += arr[i];
            } else {
                day++;
                sum = arr[i];
            }
             
        }
        return day <= days;
    }
}