class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String s : equations) {
            if(s.contains("==")) {
                int x = s.charAt(0) - 'a';
                int y = s.charAt(3) - 'a';
                uf.union(x, y);
            }
        }
        for(String s : equations) {
            if(s.contains("!=")) {
                int x = s.charAt(0) - 'a';
                int y = s.charAt(3) - 'a';
                if(uf.find(x) == uf.find(y)) return false;
            }
        }
        return true;
    }
}


public class UnionFind {
	int[] parent;
	int[] rank;
	
	public UnionFind(int n) {
		this.parent = new int[n];
		this.rank = new int[n];
		for(int i=0; i<n; i++) this.parent[i] = i;
	}
	
	public void union(int node1, int node2) {
		int parent1 = find(node1);
		int parent2 = find(node2);
		if(rank[parent1] < rank[parent2]) {
			parent[parent1] = parent2; 
		} else if(rank[parent1] > rank[parent2]) {
			parent[parent2] = parent1;
		} else {
			parent[parent2] = parent1;
			rank[parent1]++;
		}
	}
	
	public int find(int node) {
		if(parent[node] != node) {
			return parent[node] = find(parent[node]);
		}
		return parent[node];
	}
}
