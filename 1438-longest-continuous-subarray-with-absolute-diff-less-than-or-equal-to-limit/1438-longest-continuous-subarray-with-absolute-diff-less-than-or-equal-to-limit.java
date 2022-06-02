class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // 10, 1, 2, 4, 7, 2
        Deque<Integer> incQ = new LinkedList<>();
        Deque<Integer> decQ = new LinkedList<>();
        int maxLength = 1;
        int left = 0, right = 0;
        while(right < nums.length) {
            while(!incQ.isEmpty() && nums[incQ.peekLast()] >= nums[right]) {
                incQ.removeLast();
            }
            incQ.addLast(right);
            while(!decQ.isEmpty() && nums[decQ.peekLast()] <= nums[right]) {
                decQ.removeLast();
            }
            decQ.addLast(right);
            while(!incQ.isEmpty() && !decQ.isEmpty() && Math.abs(nums[incQ.peekFirst()] - nums[decQ.peekFirst()]) > limit) {
                if(incQ.peekFirst() <= left) incQ.removeFirst();
                if(decQ.peekFirst() <= left) decQ.removeFirst();
                left++;
            }
            maxLength = Math.max(right - left + 1, maxLength);
            right++;
        }
            return maxLength;
    }
}