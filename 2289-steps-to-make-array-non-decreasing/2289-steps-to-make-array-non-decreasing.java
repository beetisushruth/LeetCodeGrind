class Solution {
    public int totalSteps(int[] nums) {
        Stack<int []> st = new Stack<>();
        int ans = 0;
        for(int i=nums.length - 1; i>=0; i--) {
            int count = 0;
            while(!st.isEmpty() && st.peek()[0] < nums[i]) {
                int[] peekEle = st.pop();
                count = Math.max(peekEle[1], count + 1);
            }
            ans = Math.max(ans, count);
            st.add(new int[]{nums[i], count});
        }
        return ans;
    }
}