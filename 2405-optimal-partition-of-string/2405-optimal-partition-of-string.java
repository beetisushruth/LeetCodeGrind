class Solution {
    public int partitionString(String s) {
        int i = 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                set = new HashSet<>();
                count++;
            } 
            set.add(c);
            i++;
        }
        return count + 1;
    }
}