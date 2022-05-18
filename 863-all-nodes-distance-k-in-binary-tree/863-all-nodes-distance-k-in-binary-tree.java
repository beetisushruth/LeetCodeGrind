/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class E {
    TreeNode node;
    int dist;
    
    public E(TreeNode node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<E> q = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(root, parent);
        q.add(new E(target, 0));
        visited.add(target);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            E front = q.remove();
            if(front.dist == k) ans.add(front.node.val);
            if(front.node.left != null && !visited.contains(front.node.left)) {
                q.add(new E(front.node.left, front.dist + 1));
                visited.add(front.node.left);
            }
            if(front.node.right != null && !visited.contains(front.node.right)) {
                q.add(new E(front.node.right, front.dist + 1));
                visited.add(front.node.right);
            }
            if(parent.containsKey(front.node) && !visited.contains(parent.get(front.node))) {
                q.add(new E(parent.get(front.node), front.dist + 1));
                visited.add(parent.get(front.node));
            }
        }
        return ans;
    }
    
    public void dfs(TreeNode node, Map<TreeNode, TreeNode> parent) {
        if(node == null) return;
        if(node.left != null) parent.put(node.left, node);
        if(node.right != null) parent.put(node.right, node);
        dfs(node.left, parent);
        dfs(node.right, parent);
    }
}