class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<n; i++) {
            if(i >= k && !dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            removeSmallerIndexes(dq, nums, i);
            dq.addLast(i);
            if(i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];   
            }
        }
        return ans;
    }
    
    public void removeSmallerIndexes(Deque<Integer> dq, int[] nums, int i) {
        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
            dq.removeLast();
        }
    }
}