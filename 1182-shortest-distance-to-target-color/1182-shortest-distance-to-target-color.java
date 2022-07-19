class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        int n = colors.length;
        int[][] arr = new int[n][4];
        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        int[] colorDist = new int[4];
        Arrays.fill(colorDist, -1);
        for(int i=0; i<n; i++) {
            colorDist[colors[i]] = i;
            for(int j=1; j<4; j++) {
                if(colorDist[j] != -1) arr[i][j] = i - colorDist[j];
            }
        }
        Arrays.fill(colorDist, -1);
        for(int i=n-1; i>=0; i--) {
            colorDist[colors[i]] = i;
            for(int j=1; j<4; j++) {
                if(colorDist[j] != -1) arr[i][j] = Math.min(colorDist[j] - i, arr[i][j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            list.add(arr[x][y] == Integer.MAX_VALUE ? -1 : arr[x][y]);
        }
        return list;
    }
}