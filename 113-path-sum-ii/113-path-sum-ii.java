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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        recurse(root, ans, targetSum, 0, new ArrayList<>());
        return ans;
    }
    
    public void recurse(TreeNode node, List<List<Integer>> ans, int target, int current, List<Integer> list) {
        if(node == null) return;
        list.add(node.val);
        current += node.val;
         if(node.left == null && node.right == null && current == target) {
            ans.add(new ArrayList<>(list));
        }
        recurse(node.left, ans, target, current, list);
        recurse(node.right, ans, target, current, list);
        list.remove(list.size() - 1);
    }
}