class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int i = Math.abs(a - x);
            int j = Math.abs(b - x);
            if(i == j) return b - a;
            return j - i;
        });
        for(int num : arr) {
            pq.add(num);
            if(pq.size() > k) pq.remove();
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}