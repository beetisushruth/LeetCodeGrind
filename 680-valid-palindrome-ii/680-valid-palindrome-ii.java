class Solution {
    public boolean validPalindrome(String s) {
        int i=0;
        int j = s.length() - 1;
        while(i <= j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if(c1 != c2) {
                if(palindrome(i + 1, j , s) || palindrome(i, j - 1, s)) return true;
                else return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    
    public boolean palindrome(int i, int j, String s) {
        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}