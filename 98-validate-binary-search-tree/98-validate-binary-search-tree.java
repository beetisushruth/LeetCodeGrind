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
    public boolean isValidBST(TreeNode root) {
        return recurse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }   
    
    public boolean recurse(TreeNode node, long a, long b) {
        if(node == null) return true;
        return node.val > a && node.val < b && recurse(node.left, a, Math.min(node.val, b)) && recurse(node.right, Math.max(node.val, a), b);
    }
}