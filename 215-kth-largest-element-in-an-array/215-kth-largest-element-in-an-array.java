class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    public int quickSelect(int[] nums, int low, int high, int k) {
        int p = partition(nums, low, high, k);
        if(p == k - 1) return nums[k - 1];
        if(p < k - 1) {
            return quickSelect(nums, p + 1, high, k);
        } else {
            return quickSelect(nums, low, p - 1, k);
        }
    }
    
    public int partition(int[] nums, int low, int high, int k) {
        int pivot = nums[high], pivotIndex = low;
        for(int i=low; i<=high; i++) {
            if(pivot > nums[i]) {
                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[i];
                nums[i] = temp;
                pivotIndex++;
            }
        }
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[high];
        nums[high] = temp;
        return pivotIndex;
    }
}