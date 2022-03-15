class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(st.isEmpty()) set.add(i);
                else st.pop();
            } else if (c == '(') {  
                st.add(i);
            }
        }
        while(!st.isEmpty()) {
            set.add(st.pop());
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!set.contains(i)) {
                ans.append(c);
            } 
        }
        return ans.toString();
    }
}