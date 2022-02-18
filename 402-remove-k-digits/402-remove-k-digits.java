class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> s = new Stack<>();
        int i = 1;
        s.add(num.charAt(0));
        while(i < n) {
            char c = num.charAt(i);
            int val = c - '0';
            while(!s.isEmpty() && ((s.peek() - '0') > val) && k > 0) {
                s.pop();
                k--;
            }
            if(!s.isEmpty() || val != 0) {
                s.add(c);
            } 
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }
        if(s.isEmpty()) return "0";
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }
}