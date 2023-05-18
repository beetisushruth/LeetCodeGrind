class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indeg = new int[n];
        for(int i=0; i<edges.size(); i++) {
            int v = edges.get(i).get(1);
            indeg[v]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) ans.add(i);
        }
        return ans;
    }
}