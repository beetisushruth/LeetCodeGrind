/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
    
    public void dfs(Node node, int depth, List<List<Integer>> list) {
        if(node == null) return;
        if(list.size() <= depth) {
            list.add(new ArrayList<>());
        }
        List<Integer> row = list.get(depth);
        row.add(node.val);
        list.set(depth, row);
        for(int i=0; i<node.children.size(); i++) {
            dfs(node.children.get(i), depth + 1, list);
        }
    }
}