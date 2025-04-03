class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        } 
        for(int j= len-1;j>i;j--){
            if(i>=0 && nums[j]>nums[i]){
                swap(nums,i,j);
                break;
            }
        }  
        int start = i+1;
        int end = len-1;
        while(start < end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}