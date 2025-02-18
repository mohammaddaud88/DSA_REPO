class Solution {
    int [][] pSum;
    int m;
    int n;
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
         n = matrix.length;
         m = matrix[0].length;  
        pSum = new int[matrix.length+1][matrix[0].length+1];
        getPSum(matrix);
        for(int i=1;i<=matrix.length;i++){
            for(int j=1;j<=matrix[0].length;j++){
                if(matrix[i-1][j-1] == '1'){
                    int low = 0;
                    int high = Math.min(n,m);
                    while(low <= high){
                        int mid = (low + high)/2;
                        if(isGoodArray(i,j,mid)){
                            ans = Math.max(ans,mid*mid);
                            low = mid+1;
                        } else {
                            high = mid-1;
                        }
                    }
                }
            }
        }
        return ans;
    }
        

    public int getSum(int x,int y, int l,int r){
        return pSum[l][r] - pSum[l][y-1] - pSum[x-1][r] + pSum[x-1][y-1];
    }

    public void getPSum(char [][] arr){
    for(int i=1;i<=arr.length;i++){
        for(int j=1;j<=arr[0].length;j++){
            pSum[i][j] = (pSum[i-1][j]) + (pSum[i][j-1]) -(pSum[i-1][j-1]) + (arr[i-1][j-1]=='1'?1:0);
            }
        }
        return;
    }

    public boolean isGoodArray(int i,int j,int mid){
        int l = i+mid-1;
        int r=j+mid-1;
        if(l>n || r>m){
            return false;
        }
        return getSum(i,j,l,r)==mid*mid;
    }
}