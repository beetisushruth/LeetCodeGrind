class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Stack<String> st = new Stack<>();
        int ans = wordsDict.length;
        int count = 0;
        for(int i=0; i<wordsDict.length; i++) {
            String word = wordsDict[i];
            if(st.isEmpty() && (word.equals(word1) || word.equals(word2))) {
                st.add(word);
                count = 1;
            } else if(!st.isEmpty() && st.peek().equals(word1) && word.equals(word2)) {
                ans = Math.min(ans, count);
                st.pop();
                st.add(word2);
                count = 1;
            } else if(!st.isEmpty() && st.peek().equals(word2) && word.equals(word1)) {
                ans = Math.min(ans, count);
                st.pop();
                st.add(word1);
                count = 1;
            } else if(!st.isEmpty() && st.peek().equals(word) && (word.equals(word1) || word.equals(word2))) {
                count = 1;
            } else {
                count++;
            }
        }
        return ans;
    }
}