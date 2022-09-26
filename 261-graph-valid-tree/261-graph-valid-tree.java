class Solution {
    int[] parent;
    int[] rank;
    
    public boolean validTree(int n, int[][] edges) { 
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            if(find(edge[0]) == find(edge[1])) return false;
            union(edge[0], edge[1]);
        }
        int rootParent = find(0);
        for(int i=1; i<n; i++) {
            if(find(i) != rootParent) return false;
        }
        return true;
    }
    
    public void union(int x, int y) {
        int u = find(x);
        int v = find(y);
        if(rank[u] < rank[v]) {
            parent[u] = v;
        } else if(rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u;
            rank[u]++;
        }
    }
    
    public int find(int x) {
        if(parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}