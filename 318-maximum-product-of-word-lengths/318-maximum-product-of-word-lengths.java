class Solution {
    public int maxProduct(String[] words) {
        int[] count = new int[words.length];
        List<Set<Character>> l = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            count[i] = words[i].length();
            Set<Character> set = new HashSet<>();
            for(int j=0; j<words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
            l.add(set);
        }
        int max = 0;
        for(int i=0; i<words.length; i++) {
            for(int j=i + 1; j<words.length; j++) {
                boolean valid = true;
                Set<Character> set1 = l.get(i);
                Set<Character> set2 = l.get(j);
                for(Character c : set1) {
                    if(set2.contains(c))  {
                        valid = false;
                        break;
                    }
                }
                if(valid) max = Math.max(max, count[i]*count[j]);
            }
        }
        return max;
    }
}