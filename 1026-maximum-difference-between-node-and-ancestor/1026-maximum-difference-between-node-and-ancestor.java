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
    
    
    public int maxAncestorDiff(TreeNode root) {
        return recurse(root, Integer.MAX_VALUE, 0);
    }
    
    public int recurse(TreeNode root, int min, int max) {
        if(root == null) return 0;
        int ans = Math.max(max - root.val, root.val - min);
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        int left = recurse(root.left, min, max);
        int right = recurse(root.right, min , max);
        return Math.max(ans, Math.max(left, right));
    }
}