class Solution {
    public int minLength(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(st.empty()) st.push(c);
            else if(st.peek() == 'A' && c == 'B'){
                st.pop();
            } else if(st.peek() == 'C' && c == 'D'){
                st.pop();
            } else st.push(c);
        }
        return st.size();
    }
}