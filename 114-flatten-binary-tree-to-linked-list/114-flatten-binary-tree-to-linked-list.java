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
    
    public void flatten(TreeNode root) {
        recurse(root);
    }
    
    public TreeNode recurse(TreeNode node) {
        if(node == null) return node;
        if(node.left == null && node.right == null) return node;
        if(node.left == null) {
            node.right = recurse(node.right);
            return node;
        }
        if(node.right == null) {
            node.right = recurse(node.left);
            node.left = null;
            return node;
        }
        TreeNode temp = recurse(node.right);
        node.right = recurse(node.left);
        TreeNode rightNode = node.right;
        while(rightNode.right != null) rightNode = rightNode.right;
        rightNode.right = temp;
        node.left = null;
        return node;
    }
    
    public void printTree(TreeNode node) {
        if(node == null) return;
        System.out.print(node.val+" ");
        printTree(node.right);
    }
}