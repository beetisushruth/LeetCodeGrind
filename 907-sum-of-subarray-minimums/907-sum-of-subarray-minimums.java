class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int MOD = (int) Math.pow(10, 9) + 7;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int index = st.pop();
                int left = (st.isEmpty()) ? -1 : st.peek();
                long count = (index - left)*(i - index)%MOD;
                long product = count*arr[index]%MOD;
                sum = (int)(product + sum)%MOD;
            }
            st.add(i);
        }
        int right = arr.length;
        while(!st.empty()) {
            int index = st.pop();
            int left = (st.isEmpty()) ? -1 : st.peek();
            long count = (index - left)*(right - index)%MOD;
            long product = count*arr[index]%MOD;
            sum = (int)(product + sum)%MOD;
            // System.out.println(arr[index]+" "+count);
        }
        return sum;
    }
}