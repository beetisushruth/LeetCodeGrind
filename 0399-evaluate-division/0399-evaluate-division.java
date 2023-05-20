class Pair {
    String name;
    double value;
    
    public Pair(String name, double value) {
        this.name = name;
        this.value = value;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // a = 2b
        // b = 3c
        Map<String, List<Pair>> graph = new HashMap<>();
        
        for(int i=0; i<equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double val = values[i];
            List<Pair> list = graph.containsKey(from) ? graph.get(from) : new ArrayList<>();
            list.add(new Pair(to, val));
            graph.put(from, list);
            list = graph.containsKey(to) ? graph.get(to) : new ArrayList<>();
            list.add(new Pair(from, 1/val));
            graph.put(to, list);
        }
        double[] ans = new double[queries.size()];
        for(int i=0; i<queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            double val = findPath(from, to, graph, 1, visited);
            ans[i] = val;
        }
        return ans;
    }
    
    public double findPath(String from, String to, Map<String, List<Pair>> graph, double val, Set<String> visited) {
        visited.add(from);
        if(!graph.containsKey(from)) return -1;
        if(from.equals(to)) return val;
        for(int i=0; i< graph.get(from).size(); i++) {
            Pair pair = graph.get(from).get(i);
            String neighbor = pair.name;
            double value = pair.value;
            if(visited.contains(neighbor)) continue;
            double ans = findPath(neighbor, to, graph, val*value, visited);
            if(ans != -1) return ans;
        }
        return -1;
    }
    
}