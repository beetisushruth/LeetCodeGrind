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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }
        recurse(root, val, depth - 2);
        return root;
    }
    
    public void recurse(TreeNode node, int val, int depth) {
        if(node == null) return;
        if(depth == 0) {
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;
            temp = node.right;
                node.right = new TreeNode(val);
                node.right.right = temp;
        }
        recurse(node.left, val, depth - 1);
        recurse(node.right, val, depth - 1);
    }
}