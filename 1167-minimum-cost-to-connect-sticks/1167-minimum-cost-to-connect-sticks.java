class Solution {
    public int connectSticks(int[] sticks) {
        if(sticks.length == 1) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : sticks) {
            pq.add(num);
        }
        int sum = 0;
        while(pq.size() != 1) {
            int first = pq.remove();
            int second = pq.remove();
            sum += (first + second);
            pq.add(first + second);
        }
        return sum;
    }
}