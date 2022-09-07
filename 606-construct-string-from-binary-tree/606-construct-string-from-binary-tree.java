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
    public String tree2str(TreeNode root) {
        if(root == null) return "";
        String val = root.val + "";
        if(root.left != null) {
            val += "(" + tree2str(root.left) + ")";
        } else if(root.left == null && root.right != null) {
            val += "()";
        }
        if(root.right != null) {
            val += "(" + tree2str(root.right) + ")";
        }
        return val;
    }
}