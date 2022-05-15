class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            List<Integer> neighbors = adj.getOrDefault(u, new ArrayList<>());
            neighbors.add(v);
            adj.put(u, neighbors);
        }
        List<Integer> order = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            if(!visited.contains(i)) {
                dfs(adj, visited, order, i);
            }
        }
        int[] top = new int[numCourses];
        for(int i=0; i<order.size(); i++) top[i] = order.get(i);
        Set<Integer> set = new HashSet<>();
        Collections.reverse(order);
        set.add(order.get(0));
        for(int i=1; i<order.size(); i++) {
            if(adj.containsKey(order.get(i))) {
                for(int j=0; j<adj.get(order.get(i)).size(); j++) {
                    if(set.contains(adj.get(order.get(i)).get(j))) {
                        return new int[0];
                    }
                }
            }
            set.add(order.get(i));
        }
        return top;
    }
    
    public void dfs(Map<Integer, List<Integer>> adj, Set<Integer> visited, List<Integer> order, int i) {
        if(visited.contains(i)) return;
        visited.add(i);
        if(adj.containsKey(i)) {
            for(int j=0; j<adj.get(i).size(); j++) {
                if(!visited.contains(adj.get(i).get(j))) {
                    dfs(adj, visited, order, adj.get(i).get(j));
                }
            }
        }
        order.add(i);
    }
}