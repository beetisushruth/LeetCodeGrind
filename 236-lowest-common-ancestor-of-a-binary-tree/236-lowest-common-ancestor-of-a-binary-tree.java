/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<TreeNode> pList;
    List<TreeNode> qList;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        getLineage(root, p, q, new ArrayList<>());
        TreeNode ans = null;
        int i = 0; int j = 0;
        while(i < pList.size() && j < qList.size()) {
            if(pList.get(i) == qList.get(j)) ans = pList.get(i);
            else break;
            i++; j++;
        }
        return ans;
    }
    
    public void getLineage(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> list) {
        if(node == null) return;
        list.add(node);
        if(node == p) {
            pList = clone(list); 
        }
        if(node == q) {
            qList = clone(list);
        }
       // System.out.println(list.size() + " "+ node.val);
        getLineage(node.left, p, q, list);
        getLineage(node.right, p, q, list);
        list.remove(list.size() - 1);
    }
    
    public List<TreeNode> clone(List<TreeNode> arr) {
        List<TreeNode> ans = new ArrayList<>();
        for(int i=0; i<arr.size(); i++) {
            ans.add(arr.get(i));
        }
        return ans;
    }
}