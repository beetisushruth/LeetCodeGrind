class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word: words) set.add(word);
        List<String> ans = new ArrayList<>();
        for(String word : words) {
            if(isCorrectWord(word, 0, 0, set, new HashMap<>())) ans.add(word);
        }
        return ans;
    }
    
    public boolean isCorrectWord(String word, int start, int end, Set<String> set, Map<String, Boolean> dp) {
        //System.out.println(start+" "+end);
        if(end == start && end == word.length()) return true;
        if(end > word.length()) return false;
        boolean res = set.contains(word.substring(start, end)) && end - start != word.length() && (dp.containsKey(start+" "+end) ? dp.get(start+" "+end) : isCorrectWord(word, end, end, set, dp));
        res = res | (dp.containsKey(start+" "+(end + 1)) ? dp.get(start+" "+(end + 1)) : isCorrectWord(word, start, end + 1, set, dp));
        dp.put(start+" "+end, res);
        return res;
    }
}