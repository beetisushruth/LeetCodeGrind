class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>(); 
        for(char c : s.toCharArray()) {
            if(st.empty()) st.push(c);
            else if(st.peek() == '[' && c == ']') st.pop();
            else st.push(c);
        }
        // System.out.println((double) st.size() / 4);
        return (int) Math.ceil((double) st.size() / 4);
    }
}