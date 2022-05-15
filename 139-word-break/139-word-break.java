class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Set<String> set = new HashSet<>();
//         for(int i=0; i<wordDict.size(); i++) {
//             set.add(wordDict.get(i));
//         }
//         return wordBreakUtil(s, set, 1);
//     }
    
//     public boolean wordBreakUtil(String s, Set<String> set, int i) {
//         if(i > s.length() && s.length() == 0) return true;
//         if(i > s.length() && s.length() != 0) return false;
//         String word = s.substring(0, i);
//         return (set.contains(word) ? wordBreakUtil(s.substring(i), set, 1) : false) || wordBreakUtil(s, set, i + 1);
//     }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        q.add(0);
        while(!q.isEmpty()) {
            int start = q.remove();
            if(visited[start]) continue;
            for(int end = start + 1; end <= s.length(); end++) {
                if(set.contains(s.substring(start, end))) {
                    q.add(end);
                    if(end == s.length()) return true;
                }
            }
            visited[start] = true;
        }
        return false;
    }
}