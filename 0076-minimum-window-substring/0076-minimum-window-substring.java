class Solution {
    public String minWindow(String s, String t) {
        int[] tArr = new int[100];
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            tArr[c - 'A']++;
        }
        int[] sArr = new int[100];
        int left = 0;
        int minLength = s.length() + 1;
        int start = 0; int end = -1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            sArr[c - 'A']++;
            while(check(sArr, tArr) && left <= i) {
                if(minLength > i - left + 1) {
                    start = left;
                    end = i;
                    minLength = i - left + 1;
                }
                sArr[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return end < start ? "" : s.substring(start, end + 1);
    }
    
    public boolean check(int[] sArr, int[] tArr) {
        for(int i=0; i<tArr.length; i++) {
            if(sArr[i] < tArr[i]) return false;
        }
        return true;
    }
}