/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class IntNode extends Node {
    int val;
    Node left;
    Node right;
    public IntNode(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public int evaluate() {
        return this.val;
    }
}

class AddNode extends Node {
    Node left;
    Node right;
    
    public AddNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    
    public int evaluate() {
        return this.left.evaluate() + this.right.evaluate();
    }
}

class SubNode extends Node {
    Node left;
    Node right;
    
    public SubNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    
    public int evaluate() {
        return this.left.evaluate() - this.right.evaluate();
    }
}

class MultiNode extends Node {
    Node left;
    Node right;
    
    public MultiNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    
    public int evaluate() {
        return this.left.evaluate() * this.right.evaluate();
    }
}

class DivNode extends Node {
    Node left;
    Node right;
    
    public DivNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    
    public int evaluate() {
        return this.left.evaluate() / this.right.evaluate();
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> st = new Stack<>(); 
        Node node;
        for(String symbol : postfix) {
            if(symbol.equals("+")) {
                Node right = st.pop();
                Node left = st.pop();
                node = new AddNode(left, right);
            } else if(symbol.equals("-")) {
                Node right = st.pop();
                Node left = st.pop();
                node = new SubNode(left, right);
            } else if(symbol.equals("*")) {
                Node right = st.pop();
                Node left = st.pop();
                node = new MultiNode(left, right);
            } else if(symbol.equals("/")) {
                Node right = st.pop();
                Node left = st.pop();
                node = new DivNode(left, right);
            } else{
                node = new IntNode(Integer.parseInt(symbol), null, null);
            }
            st.add(node);
        }
        return st.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */