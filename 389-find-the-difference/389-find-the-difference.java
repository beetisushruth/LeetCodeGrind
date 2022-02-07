class Solution {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            arr[c - 'a']--;
        }
        for(int i=0; i<26; i++) {
            if(arr[i] < 0) return (char) (i + 'a');
        }
        return 'a';
    }
}