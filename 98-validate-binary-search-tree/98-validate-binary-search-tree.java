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
        List<Integer> arr = new ArrayList<>();
        recurse(root, arr);
        for(int i=1; i<arr.size(); i++) {
            if(arr.get(i - 1) >= arr.get(i)) return false;
        }
        return true;
    }   
    
    public void recurse(TreeNode node, List<Integer> arr) {
        if(node == null) return;
        recurse(node.left, arr);
        arr.add(node.val);
        recurse(node.right, arr);
    }
}