class NumArray {

    ArrayList<Integer> list = new ArrayList<>();
    // list.add(0);
    public NumArray(int[] nums) {
        list.add(nums[0]);
    
        for(int i=1;i<nums.length;i++){
            nums[i] = nums[i-1]+nums[i];
            list.add(nums[i]);
        }
    }
    
    public int sumRange(int left, int right) {
        if(left > 0){
        return list.get(right)-list.get(left-1);
        } else {
            return list.get(right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */