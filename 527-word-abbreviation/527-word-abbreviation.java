class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, List<IndexedWord>> groups = new HashMap();
        String[] ans = new String[words.size()];

        int index = 0;
        for (String word: words) {
            String ab = abbrev(word, 0);
            if (!groups.containsKey(ab))
                groups.put(ab, new ArrayList());
            groups.get(ab).add(new IndexedWord(word, index));
            index++;
        }

        for (List<IndexedWord> group: groups.values()) {
            Collections.sort(group, (a, b) -> a.word.compareTo(b.word));

            int[] lcp = new int[group.size()];
            for (int i = 1; i < group.size(); ++i) {
                int p = longestCommonPrefix(group.get(i-1).word, group.get(i).word);
                lcp[i] = p;
                lcp[i-1] = Math.max(lcp[i-1], p);
            }

            for (int i = 0; i < group.size(); ++i)
                ans[group.get(i).index] = abbrev(group.get(i).word, lcp[i]);
        }

        return Arrays.asList(ans);
    }

    public String abbrev(String word, int i) {
        int N = word.length();
        if (N - i <= 3) return word;
        return word.substring(0, i+1) + (N - i - 2) + word.charAt(N-1);
    }

    public int longestCommonPrefix(String word1, String word2) {
        int i = 0;
        while (i < word1.length() && i < word2.length()
                && word1.charAt(i) == word2.charAt(i))
            i++;
        return i;
    }
}

class IndexedWord {
    String word;
    int index;
    IndexedWord(String w, int i) {
        word = w;
        index = i;
    }
}
