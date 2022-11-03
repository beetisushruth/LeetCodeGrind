class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        boolean found = false;
        int count = 0;
        for(String key : map.keySet()) {
            if(key.charAt(0) == key.charAt(1)) {
                int num = map.get(key);
                if(num%2 == 0) {
                    count += num;
                } else {
                    count += num - 1;
                    found = true;
                }
            } else {
                String rev = key.charAt(1)+""+key.charAt(0);
                if(key.charAt(0) < key.charAt(1) && map.containsKey(rev)) {
                    int num = Math.min(map.get(rev), map.get(key));
                    count += 2*num;
                }
            }
        }
        return 2*(count + (found ? 1 : 0));
    }
}