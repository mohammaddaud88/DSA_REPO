class Solution {
    public int maxProfit(int[] arr) {
        int buy = arr[0];
        int profit =0;
        int n = arr.length;
        for(int i=1;i<n;i++){
            if(buy > arr[i]){
                buy = arr[i];
            } else if(arr[i]-buy > 0){
                profit += arr[i]-buy;
                buy = arr[i];
            }
        }
        return profit;
    }
}