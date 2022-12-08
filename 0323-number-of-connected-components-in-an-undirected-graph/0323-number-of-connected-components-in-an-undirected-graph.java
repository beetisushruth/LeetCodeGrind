class Solution {
    public int countComponents(int n, int[][] edges) {
        List[] adjList = new ArrayList[n];
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited.contains(i)){
                count += dfs(adjList, visited, i);
            } 
        }
        return count;
    }
    
    public int dfs(List[] adjList, Set<Integer> visited, int i) {
        visited.add(i);
        List<Integer> neighbors = adjList[i];
        for(int j=0; j<neighbors.size(); j++) {
            if(!visited.contains(neighbors.get(j))) dfs(adjList, visited, neighbors.get(j));
        }
        return 1;
    }
}