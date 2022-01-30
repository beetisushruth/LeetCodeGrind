class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if(k == 0) return;
        rotateUtil(nums, 0, nums.length - 1);
        rotateUtil(nums, 0, k - 1);
        rotateUtil(nums, k , nums.length - 1);
    }
    
    public void rotateUtil(int[] nums, int start, int end) {
        int mid = (end - start)/2;
        for(int i=0; i<=mid; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
}