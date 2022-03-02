class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()) return false;
        if(s.equals(t)) return true;
        int i = 0;
        for(int j=0; j<t.length(); j++) {
            if(i < s.length() && s.charAt(i) == t.charAt(j)) {
                i++;
            }
            if(i == s.length()) return true;
        }
        return false;
    }
}