class Solution {
    public int myAtoi(String s) {
        s = s.strip();
        int i = 0;
        int num = 0;
        boolean neg = false;
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '-' ) {
            neg = true;
            i++;
        }
        if(s.charAt(0) == '+') i++;
        while(i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
            int val = (s.charAt(i) - '0');
            if(Integer.MAX_VALUE/10 < num || Integer.MAX_VALUE/10 == num && Integer.MAX_VALUE %10 < val) return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                
            num = num*10 + val;
            i++;
        }
        return neg ? -num : num;
    }
}