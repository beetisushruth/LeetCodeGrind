class StockSpanner {
    
    Stack<int[]> st;
    public StockSpanner() {
        this.st = new Stack<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!this.st.isEmpty() && this.st.peek()[0] <= price ) {
            count += st.pop()[1];
        }
        st.add(new int[]{price, count});
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */