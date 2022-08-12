/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Node {
    TreeNode node;
    int val;
    
    public Node(TreeNode node, int val) {
        this.node = node;
        this.val = val;
    }
}

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = levelOrder(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
    
    public TreeMap<Integer, List<Integer>> levelOrder(TreeNode node) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        if(node != null) q.add(new Node(node, 0));
        while(!q.isEmpty()) {
            Node n = q.remove();
            TreeNode curr = n.node;
            int val = n.val;
            List<Integer> list = map.getOrDefault(val, new ArrayList<>());
            list.add(curr.val);
            map.put(val, list);
            if(curr.left != null) q.add(new Node(curr.left, val - 1));
            if(curr.right != null) q.add(new Node(curr.right, val + 1));
        }
        return map;
    }
}