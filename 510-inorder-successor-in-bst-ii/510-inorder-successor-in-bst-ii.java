/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    int maxValue = Integer.MAX_VALUE;
    Node ans = null;
    public Node inorderSuccessor(Node node) {
        Node root = null;
        Node temp = node;
        while(temp != null && temp.parent != null) {
            temp = temp.parent;
        }
        root = temp;
        traverse(root, node);
        return ans;
    }
    
    public void traverse(Node node, Node req) {
        if(node == null) return;
        if(node.val > req.val && maxValue > node.val) {
            maxValue = node.val;
            ans = node;
        }
        traverse(node.left, req);
        traverse(node.right, req);
    }
}