class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        int index = s.length();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '6') {
                index = i;
                break;
            }
        }
        if(index == s.length()) return num;
        return Integer.parseInt(s.substring(0, index) + "9" + s.substring(index + 1, s.length()));
    }
}