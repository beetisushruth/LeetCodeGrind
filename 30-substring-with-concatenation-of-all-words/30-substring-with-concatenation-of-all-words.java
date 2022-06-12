class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=s.length()-wordLen; i++) {
            Map<String, Integer> temp = new HashMap<>();
            int j = i; int count = 0;
            while(j < s.length() && j + wordLen <= s.length() && count < words.length) {
                String word = s.substring(j, j + wordLen);
                temp.put(word, temp.getOrDefault(word, 0) + 1);
                count++;
                j += wordLen;
            }
            if(match(map, temp)) list.add(i);
        }
        return list;
    }
    
    public boolean match(Map<String, Integer> map1, Map<String, Integer> map2) {
        for(String key : map1.keySet()) {
            if(!map2.containsKey(key) || !map1.get(key).equals(map2.get(key))) return false;
        }
        return true;
    }
}