class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map =new TreeMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i][0],nums1[i][1]);
        }
        for(int i=0;i<nums2.length;i++){
            int count = map.getOrDefault(nums2[i][0],0);
            map.put(nums2[i][0],nums2[i][1]+count);
        }
        int ans[][] = new int[map.size()][2];
        final int [] j={0};
        map.forEach((key,value) -> {
            ans[j[0]][0]=key;
            ans[j[0]][1]=value;
            j[0]++;
        });
        return ans;
    }
}