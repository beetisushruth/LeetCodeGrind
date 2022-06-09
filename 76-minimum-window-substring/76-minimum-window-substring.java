class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int minLength = s.length() + 1;
        String ans = "";
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            while(left <= i && !tmap.containsKey(s.charAt(left))) {
                smap.put(s.charAt(left), smap.get(s.charAt(left)) - 1);
                left++;
            }
            while(left <= i && contains(smap, tmap)) {
                if(minLength > i - left + 1) {
                    minLength = i - left + 1;
                    ans = s.substring(left, i + 1);
                }
                smap.put(s.charAt(left), smap.get(s.charAt(left)) - 1);
                left++;
            }
        }
        return ans;
    }
    
    public boolean contains(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for(char c : tmap.keySet()) {
            if(!smap.containsKey(c)) return false;
            if(smap.get(c) < tmap.get(c)) return false;
        }
        return true;
    }
}