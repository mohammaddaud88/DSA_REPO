class Solution {
    public int mySqrt(int x) {
        long left =1;
        long right =x;
        long ans =0;
        while(left<=right){
            long mid =left +  (right - left)/2;
            if(mid*mid <= x){
                ans=mid;
                left = mid+1;
            } else {
                right = mid-1;
            } 
        }
        return (int) ans;

    }
}