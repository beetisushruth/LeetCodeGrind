class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) return a[1] - a[0] - b[1] + b[0];
            return a[1] - b[1];
        });
        for(int i=0; i<nums.length; i++) {
            while(!pq.isEmpty() && pq.peek()[1] + 1 < nums[i]) {
                if(pq.peek()[1] - pq.peek()[0] + 1 < 3) return false;
                pq.remove();
            }
            if(pq.isEmpty() || pq.peek()[1] == nums[i]) {
                pq.add(new int[]{nums[i], nums[i]});
            }
            else if(pq.peek()[1] + 1 == nums[i]) {
                int[] peek = pq.remove();
                peek[1] = nums[i];
                pq.add(peek);
            }
        }
        while(pq.size() > 0) {
            int[] peek = pq.remove();
            if(peek[1] - peek[0] + 1 < 3) return false;
        }
        return true;
    }
}