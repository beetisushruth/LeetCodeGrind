class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1, k = n - 1;
        int[] ans = new int[n];
        while(i <= j) {
            int left = nums[i]*nums[i];
            int right = nums[j]*nums[j];
            if(left >= right) {
                ans[k] = left;
                i++;
            } else {
                ans[k] = right;
                j--;
            }
            k--;
        }
        return ans;
    }
}