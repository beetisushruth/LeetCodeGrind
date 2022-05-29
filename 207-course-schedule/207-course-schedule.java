class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++) {
            if(prerequisites[i][0] == prerequisites[i][1]) return false;
            List<Integer> neighbors = map.getOrDefault(prerequisites[i][0], new ArrayList<>());
            neighbors.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], neighbors);
        }
        List<Integer> finishOrder = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        for(int key : map.keySet()) {
            if(!visited[key]) {
                visited[key] = true;
                dfs(map, finishOrder, visited, key);
            }
        }
        // iterate from reverse direction to get Topological ordering
        Set<Integer> set = new HashSet<>();
        for(int i=finishOrder.size() - 1; i>=0; i--) {
            int course = finishOrder.get(i);
            if(map.containsKey(course)) {
                for(int j=0; j<map.get(course).size(); j++) {
                    if(set.contains(map.get(course).get(j))) return false;
                }
            }
            set.add(course);
        }
        return true;
    }
    
    public void dfs(Map<Integer, List<Integer>> map, List<Integer> finishOrder, boolean[] visited, int course) {
        if(map.containsKey(course)) {
            for(int i=0; i<map.get(course).size(); i++) {
                int neighbor = map.get(course).get(i);
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    dfs(map, finishOrder, visited, neighbor);
                }
            }
        }
        finishOrder.add(course);
    }
}