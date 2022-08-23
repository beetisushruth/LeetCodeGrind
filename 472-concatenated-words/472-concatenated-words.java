class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word: words) set.add(word);
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            if(isCorrectWord(word, 0, 0, set)) ans.add(word);
        }
        return ans;
    }
    
    public boolean isCorrectWord(String word, int start, int end, Set<String> set) {
        //System.out.println(start+" "+end);
        if(end == start && end == word.length()) return true;
        if(end > word.length()) return false;
        boolean res = set.contains(word.substring(start, end)) && end - start != word.length() && isCorrectWord(word, end, end, set);
        res = res | isCorrectWord(word, start, end + 1, set);
        return res;
    }
}