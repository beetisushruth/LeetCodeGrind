class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        int[] diff1 = new int[n];
        int[] diff2 = new int[n];
        for(int i=0; i<nums1.length; i++) {
            diff1[i] = nums2[i] - nums1[i];
            diff2[i] = nums1[i] - nums2[i];
        }
        int curr = 0, sum = 0;
        for(int num : diff1) {
            curr = Math.max(num, curr + num);
            sum = Math.max(sum, curr);
        }
        int ans = Math.max(sum1, Math.max(sum2, sum1 + sum));
        curr = 0; sum = 0;
        for(int num : diff2) {
            curr = Math.max(num, curr + num);
            sum = Math.max(sum, curr);
        }
        return Math.max(ans, sum + sum2);
    }
}