class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        int[] arr = new int[nums.length + 1];
        arr[0] = 0;
        for(int i=0; i<nums.length; i++) {
            arr[i + 1] += arr[i] + nums[i];
        }
        this.nums = arr;
    }
    
    public int sumRange(int left, int right) {
        return nums[right + 1] - nums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */