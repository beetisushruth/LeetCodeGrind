class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        recurse(0, 0, list, "", n);
        return list;
    }
    
    public void recurse(int open, int close, List<String> list, String s, int n) {
        if(open + close == 2*n && open == close) {
            list.add(s);
        }
        if(open > n || close > n) return;
        recurse(open + 1, close, list, s+"(", n);
        if(open > close) {
            recurse(open, close + 1, list, s+")", n);
        }
    }
}