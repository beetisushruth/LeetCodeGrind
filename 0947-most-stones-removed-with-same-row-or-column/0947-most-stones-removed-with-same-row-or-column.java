class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0; j<n; j++) {
                if(j != i && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
                    row.add(j);
                }
            }
            list.add(row);
        }
        boolean[] seen = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!seen[i]) {
                dfs(list, seen, i);
                count++;
            }
        }
        return n - count;
    }
    
    public void dfs(List<List<Integer>> list, boolean[] seen, int i) {
        if(seen[i]) return;
        seen[i] = true;
        List<Integer> children = list.get(i);
        for(int j=0; j<children.size(); j++) {
            dfs(list, seen, children.get(j));
        }
    }
}