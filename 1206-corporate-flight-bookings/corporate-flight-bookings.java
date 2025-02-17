class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int [] pSum = new int[n+1];
        int [] ans = new int [n];
        for(int i=0;i<bookings.length;i++){
            pSum[bookings[i][0]-1] += bookings[i][2];
            pSum[bookings[i][1]] -= bookings[i][2];
        }
        ans[0]=pSum[0];
        for(int i=1;i<n;i++){
            pSum[i] = pSum[i-1]+pSum[i];
            ans [i]=pSum[i];
        }





        // for(int i=0;i<n;i++){
        //     map.put(i+1,0);
        // }
        // for(int i=0;i<bookings.length;i++){
        //     for(int j=bookings[i][0];j<=bookings[i][1];j++){
        //         int val = map.getOrDefault(j,0);
        //         map.put(j,val+bookings[i][2]);
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     res[i]=map.get(i+1);
        // }
        return ans;
    }
}