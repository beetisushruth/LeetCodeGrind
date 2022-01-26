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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        preorder(root1, arr1);
        preorder(root2, arr2);
        List<Integer> arr = merge(arr1, arr2);
        return arr;
    }
    
    public void preorder(TreeNode node, List<Integer> arr) {
        if(node != null) {
            preorder(node.left, arr);
            arr.add(node.val);
            preorder(node.right, arr);
        }
    }
    
    public List<Integer> merge(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> arr = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.size() && j < arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
            } else {
                arr.add(arr2.get(j));
                j++;
            }
        }
        while(i < arr1.size()) {
            arr.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()) {
            arr.add(arr2.get(j));
            j++;
        }
        return arr;
    }
}
