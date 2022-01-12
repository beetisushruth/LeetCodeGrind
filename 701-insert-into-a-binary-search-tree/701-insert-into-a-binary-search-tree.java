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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode newNode = new TreeNode(val);
        if(root == null) return newNode;
        while(node != null) {
            if(node.val < val) {
                if(node.right == null) {
                    node.right = newNode;
                    break;
                }
                node = node.right;
            } else {
                if(node.left == null) {
                    node.left = newNode;
                    break;
                }
                node = node.left;
            }
        }
        return root;
    }
}