class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(s));
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if(map.get(a) == map.get(b)) {
               return b.compareTo(a);
           } 
           return map.get(a) - map.get(b);
        });
        for(String key : map.keySet()) {
            pq.add(key);
            if(pq.size() > k) pq.remove();
        }
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()) list.add(pq.remove());
        Collections.reverse(list);
        return list;
    }
}