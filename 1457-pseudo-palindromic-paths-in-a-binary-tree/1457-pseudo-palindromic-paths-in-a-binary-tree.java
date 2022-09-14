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
    public int pseudoPalindromicPaths (TreeNode root) {
        return recurse(root, new int[10]);
    }
    
    public int recurse(TreeNode node, int[] arr) {
        if(node == null) return 0;
        arr[node.val]++;
        int val = 0;
        if(node.left == null && node.right == null && isPal(arr)){
            val = 1;
        } else {
            val = recurse(node.left, arr) + recurse(node.right, arr);
        }
        arr[node.val]--;
        return val;
    }
    
    public boolean isPal(int[] arr) {
        boolean found = false;
        for(int i=1; i<=9; i++) {
            if(arr[i]%2 == 1 && !found) found = true;
            else if(arr[i]%2 == 1 && found) return false;
        }
        return true;
    }
}