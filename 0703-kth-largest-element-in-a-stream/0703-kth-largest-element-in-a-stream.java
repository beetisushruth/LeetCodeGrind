class KthLargest {

    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((a, b) -> a - b);
        for(int num : nums) {
            add(num);
        }
    }
    // 2, 3, 4, 5, 8
    public int add(int val) {
        this.pq.add(val);
        if(this.pq.size() > k) this.pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */