class Node {
    int val = -1;
    int inc = 0;
    
    public Node(int val) {
        this.val = val;
        
    }
    
    public void increment(int inc) {
        this.inc += inc;
    }
    
    public int getValue() {
        return val + inc;
    }
    
    public int getIncrement() {
        return inc;
    }
}

class CustomStack {
    
    private Node[] arr;
    int headIndex = -1;
    int tailIndex = -1;
    
    public CustomStack(int maxSize) {
        arr = new Node[maxSize];
    }
    
    public void push(int x) {
        Node n = new Node(x);
        int newTailIndex = tailIndex + 1;
        if(newTailIndex < arr.length) {
            arr[newTailIndex] = n;
            tailIndex = newTailIndex;
            if(headIndex == -1) {
                headIndex = 0;
            }
        }
    }
    
    public int pop() {
        if(tailIndex == -1) return -1;
        int val = arr[tailIndex].getValue();
        if(tailIndex == 0) {
            arr[0] = null;
            tailIndex = -1;
            headIndex = -1;
        } else {
            int prevTailIndex = tailIndex - 1;
            arr[prevTailIndex].increment(arr[tailIndex].getIncrement());
            arr[tailIndex] = null;
            tailIndex = prevTailIndex;
        }
        
        return val;
    }
    
    public void increment(int k, int val) {
        int kToUse = k > tailIndex + 1 ? tailIndex : k - 1;
        if(kToUse != -1) {
         Node n = arr[kToUse];
         n.increment(val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */