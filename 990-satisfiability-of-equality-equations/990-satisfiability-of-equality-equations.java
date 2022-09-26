class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet(26);
        for(int i=0; i<equations.length; i++) {
            String equation = equations[i];
            if(equation.contains("==")) {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                ds.union(x, y);
            }
        }
        
        for(int i=0; i<equations.length; i++) {
            String equation = equations[i];
            if(equation.contains("!=")) {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                if(ds.find(x) == ds.find(y)) return false;
            }
        }
        return true;
    }
}

class DisjointSet {
    int[] arr;
    int[] rank;
    public DisjointSet(int n) {
        arr = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) arr[i] = i;
    }
    
    public int find(int node) {
        if(arr[node] != node) {
            return arr[node] = find(arr[node]);
        }
        return arr[node];
    }
    
    public void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if(rank[parent1] < rank[parent2]) {
            arr[parent1] = parent2;
        } else if(rank[parent1] > rank[parent2]) {
            arr[parent2] = parent1;
        } else {
            arr[parent2] = parent1; 
            rank[parent1]++;
        }
    }
}