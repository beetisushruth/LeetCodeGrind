class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = height[0];
        for(int i=1; i<n - 1; i++) {
            left[i] = max;
            max = Math.max(max, height[i]);
        }
        max = height[n - 1];
        for(int i=n-2; i>=1; i--) {
            right[i] = max;
            max = Math.max(max, height[i]);
        }
        int sum = 0;
        for(int i=1; i<n-1; i++) {
            int bar = Math.min(left[i], right[i]);
            sum += (bar < height[i] ? 0 : bar - height[i]);
        }
        return sum;
    }
}