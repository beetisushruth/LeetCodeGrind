class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        return getTotal(nums, n, true) - getTotal(nums, n, false);
    }
    
    public long getTotal(int[] nums, int n, boolean isMaximum) {
        long total = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && (isMaximum ? nums[st.peek()] <= nums[i] : nums[st.peek()] >= nums[i])) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek(); 
            st.add(i);
        }
        st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && (isMaximum ? nums[st.peek()] < nums[i] : nums[st.peek()] > nums[i])) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek(); 
            st.add(i);
        }
        for(int i=0; i<n; i++) {
            total += (long) (i - left[i])*(right[i] - i)*nums[i];
        }
        return total;
    }
}