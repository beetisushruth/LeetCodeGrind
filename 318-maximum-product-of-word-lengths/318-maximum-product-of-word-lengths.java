class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(String s : words) {
            int mask = 0;
            for(int i=0; i<s.length(); i++) {
                mask |= 1 << (s.charAt(i) - 'a');
            }
            map.put(mask, Math.max(map.getOrDefault(mask, 0), s.length()));
        }
        int max = 0;
        for(int mask1 : map.keySet()) {
            for(int mask2 : map.keySet()) {
                if((mask1 & mask2) == 0) max = Math.max(max, map.get(mask1) * map.get(mask2));
            }  
        }
        return max;
    }
}