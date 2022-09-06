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
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        int val = prune(root);
        return val == 0 && root.val == 0 ? null : root;
    }
    
    public int prune(TreeNode node) {
        if(node == null) return 0;
        int left = prune(node.left);
        int right = prune(node.right);
        if(left == 0) node.left = null;
        if(right == 0) node.right = null;
        return left | right | node.val;
    }
}