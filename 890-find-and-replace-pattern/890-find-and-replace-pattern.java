class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            int j = 0;
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            boolean match = true;
            while(j < word.length()) {
                char c = word.charAt(j);
                char p = pattern.charAt(j);
                if(map.containsKey(c)) {
                    if(map.get(c) != p) {
                        match = false; break;
                    }
                } else {
                    if(set.contains(p)) {
                        match = false; break;
                    } else {
                        set.add(p);
                        map.put(c, p);
                    }
                }
                j++;
            }
            if(match) list.add(word);
        }
        return list;
    }
}