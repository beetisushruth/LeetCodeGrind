class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int start = 1;
        int end = n - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            int count = countLess(nums, mid);
            if(count <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    public int countLess(int[] nums, int num) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= num) count++;
        }
        return count;
    }
}