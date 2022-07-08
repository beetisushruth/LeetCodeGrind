class Solution {
    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        int prev = -1;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            int max = 0;
            int index = -1;
            for(int j=0; j<26; j++) {
                if(j != prev && max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
            }
            if(index == -1) return "";
            sb.append((char) (index + 'a'));
            arr[index]--;
            prev = index;
        }
        return sb.toString();
    }
}