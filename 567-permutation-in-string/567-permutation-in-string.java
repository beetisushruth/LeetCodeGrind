class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] arr = new int[26];
        int[] ref = new int[26];
        for(int i=0; i<s1.length(); i++) {
            ref[s1.charAt(i) - 'a']++;
        }
        for(int i=0; i<s2.length(); i++) {
            if(i >= s1.length()) {
                char c = s2.charAt(i - s1.length());
                arr[c - 'a']--;
            }
            arr[s2.charAt(i) - 'a']++;
            if(i >= s1.length() - 1 && check(arr, ref)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean check(int[] arr, int[] ref) {
        for(int i=0; i<26; i++) {
            if(arr[i] != ref[i]) return false;
        }
        return true;
    }
}