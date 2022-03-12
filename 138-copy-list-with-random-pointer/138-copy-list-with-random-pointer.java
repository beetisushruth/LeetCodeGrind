/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(-1);
        Node origNode = head;
        Node newNode = newHead;
        while(origNode != null) {
            newNode.next = map.getOrDefault(origNode, new Node(origNode.val));
            newNode = newNode.next;
            map.put(origNode, newNode);
            Node origRandomNode = origNode.random;
            Node newRandomNode = map.getOrDefault(origRandomNode, origNode.random == null ? null : new Node(origNode.random.val));
            newNode.random = newRandomNode;
            map.put(origRandomNode, newRandomNode);
            origNode = origNode.next;
        }
        return newHead.next;
    }
}