class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int i=0;
        int j= (int)1e9;
        int ans =-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(isPossible(weights,mid,days)){
                ans = mid;
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int [] arr, int target, int maxDays){
        int day =1;
        int sum =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > target){
                return false;
            }else if(sum + arr[i] <= target){
                sum += arr[i];
            }else {
                day++;
                sum = arr[i];
            }
        }
        return day <= maxDays;
    }
}