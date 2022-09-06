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
    public int ans = 0;
    
    public int longestConsecutive(TreeNode root) {
        recurse(root, 1);
        return ans;
    }
    
    public void recurse(TreeNode node, int curr) {
       if(node == null) return;
        ans = Math.max(curr, ans);
        if(node.left != null) {
            if(node.val + 1 == node.left.val) recurse(node.left, curr + 1);
            else recurse(node.left, 1);
        } if(node.right != null) {
            if(node.val + 1 == node.right.val) recurse(node.right, curr + 1);
            else recurse(node.right, 1);
        }
    }
}