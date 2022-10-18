class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s = countAndSay(n - 1);
        char curr = s.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<s.length(); i++) {
            if(curr == s.charAt(i)) {
                count++;
            } else {
                sb.append(count+"");
                sb.append(curr);
                count = 1;
                curr = s.charAt(i);
            }
        }
        sb.append(count+"");
        sb.append(curr);
        return sb.toString();
    }
}