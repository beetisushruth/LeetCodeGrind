class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(set.contains(num)) {
                pq.remove(num);
            }
            pq.add(num);
            set.add(num);
            if(pq.size() > k) {
                num = pq.remove();
                set.remove(num);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.remove();
        }
        return res;
    }
}