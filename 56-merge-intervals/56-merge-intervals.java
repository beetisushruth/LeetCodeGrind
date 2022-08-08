class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
           if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        Stack<int[]> st = new Stack<>();
        st.add(intervals[0]);
        for(int i=1; i<intervals.length; i++) {
            int[] interval = intervals[i];
            if(st.peek()[0] <= interval[0] && st.peek()[1] >= interval[0]) {
                int[] pre = st.pop();
                interval[0] = Math.min(interval[0], pre[0]);
                interval[1] = Math.max(interval[1], pre[1]);
            }
            st.add(interval);
        }
        int[][] ans = new int[st.size()][2];
        int i = ans.length - 1;
        while(!st.isEmpty()) {
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}