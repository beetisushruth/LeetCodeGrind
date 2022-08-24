class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0; i<n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }
        int wall = -1;
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '|') wall = i;
            left[i] = wall;
        }
        wall = n;
        for(int i=n-1; i>=0; i--) {
            if(s.charAt(i) == '|') wall = i;
            right[i] = wall;
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]];
            int y = left[query[1]];
            //System.out.println(x + " "+y);
            if(y < x) ans[i] = 0;
            else {
                int total = prefixSum[y + 1] - prefixSum[x];
                ans[i] = total;
            }
        }
        return ans;
    }
}