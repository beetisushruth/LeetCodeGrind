class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;
        Map<Character, String> cmap = new HashMap<>();
        Map<String, Character> wmap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            // System.out.println(c);
            if(cmap.containsKey(c) && !cmap.get(c).equals(words[i])) return false;
            // System.out.println("-");
            if(wmap.containsKey(words[i]) && wmap.get(words[i]) != c) return false;
            cmap.put(c, words[i]);
            wmap.put(words[i], c);
        }
        return true;
    }
}