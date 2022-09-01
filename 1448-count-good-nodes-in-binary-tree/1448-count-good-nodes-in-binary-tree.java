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
    public int goodNodes(TreeNode root) {
        return recurse(root, root.val);
    }
    
    public int recurse(TreeNode node, int parent) {
        if(node == null) return 0;
        int val = node.val < parent ? 0 : 1;
        if(node.left != null) val += recurse(node.left, Math.max(parent, node.left.val));
        if(node.right != null) val += recurse(node.right, Math.max(parent, node.right.val));
        return val;
    }
}