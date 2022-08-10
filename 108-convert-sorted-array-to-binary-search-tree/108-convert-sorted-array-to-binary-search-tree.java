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
    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums, 0, nums.length - 1);
    }
    
    public TreeNode getTree(int[] nums, int left, int right) {
        if(left > right) return null;
        if(left == right) return new TreeNode(nums[left]);
        int mid = left + (right - left)/2;
        TreeNode middle = new TreeNode(nums[mid]);
        middle.left = getTree(nums, left, mid - 1);
        middle.right = getTree(nums, mid + 1, right);
        return middle;
    }
}