class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word : words) {
            set.add(word);
        }
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            if(isSubWordsMatch(word, 0, set)) ans.add(word);
        }
        return ans;
    }
    
    public boolean isSubWordsMatch(String word, int start, Set<String> set) {
        if(start == word.length()) return true;
        boolean ans = false;
        for(int i=start; i<word.length(); i++) {
            if(set.contains(word.substring(start, i + 1)) && i - start + 1 != word.length()){
                ans |= isSubWordsMatch(word, i + 1, set);
            }
        }
        return ans;
    }
}