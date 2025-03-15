class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = (int ) 1e8;
        int ans =-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(isPossible(weights,mid,days)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int [] arr, int target, int days){
        int day =1;
        int sum =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>target){
                return false;
            } else if(arr[i]+sum <=target){
                sum +=arr[i];
            } else {
                sum=arr[i];
                day++;
            }
        }
        return day<=days;
    }
}