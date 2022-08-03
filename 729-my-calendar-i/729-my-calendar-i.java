class Node {
    int start;
    int end;
    Node left;
    Node right;
    
    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MyCalendar {
    Node root;
    
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if(root == null) {
            root = new Node(start, end);
            return true;
        } 
        return insertNode(start, end, root);
    }
    
    public boolean insertNode(int start, int end, Node node) {
        if(node.start >= end) {
            if(node.left == null) {
                node.left = new Node(start, end);
                return true;
            }
            return insertNode(start, end, node.left);
        }
        else if(node.end <= start) {
            if(node.right == null) {
                node.right = new Node(start, end);
                return true;
            }
            return insertNode(start, end, node.right);
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */