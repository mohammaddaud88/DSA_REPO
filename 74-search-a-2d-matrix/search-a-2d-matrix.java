class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;

            int low = 0;
            int high = n*m-1;
            while(low <= high){
                int mid = (low + high)/2;
                if(matrix[mid/n][mid%n] < target){
                    low = mid+1;
                } else if(matrix[mid/n][mid%n] > target){
                    high = mid-1;
                } else {
                    return true;
                }
            }

            return false;


        // bruth force approach

        // int m = matrix.length;
        // int n = matrix[0].length-1;
        // for(int i=0;i<m;i++){
        //     if(binarySearch(matrix[i],target,0,n)){
        //         return true;
        //     }
        // }
        // return false;
    }
    // public boolean binarySearch(int[] matrix, int target, int low, int high){
    //     while(low <= high){
    //         int mid = (low+high)/2;
    //         if(matrix[mid] == target){
    //             return true;
    //         } else if(matrix[mid] > target){
    //             high = mid-1;
    //         } else {
    //             low = mid+1;
    //         }
    //     }
    //     return false;
    // }
}