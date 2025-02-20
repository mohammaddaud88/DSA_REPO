class Solution {
    public String largestNumber(int[] nums) {
        Integer arr[] = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr, (a,b) -> {
            return (b + ""+a).compareTo(a + ""+b);
        });
        if(arr[0] == 0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for(int x:arr){
           ans.append(x);
        }
        return ans.toString();
    }
}