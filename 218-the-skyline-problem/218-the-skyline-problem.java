
// Define the disjoint-set structure.
class UnionFind {
    int[] root;
    public UnionFind(int n) {
        this.root = new int[n];
        for (int i = 0; i < n; ++i)
            root[i] = i;
    }
    public int find(int x) {
        return root[x] == x ? x : (root[x] = find(root[x]));
    }
    public void union(int x, int y) {
        root[x] = root[y];
    }
}
    
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // Sort the unique positions of all the edges.
        SortedSet<Integer> edgeSet = new TreeSet<>();
        for (int[] building : buildings) {
            edgeSet.add(building[0]);
            edgeSet.add(building[1]);
        }
        Integer[] edges = edgeSet.toArray(new Integer[edgeSet.size()]);
        Arrays.sort(edges);
        
        // Hast table 'edgeIndexMap' record every {position : index} pairs in edges.
        Map<Integer, Integer> edgeIndexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < edges.length; ++i)
            edgeIndexMap.put(edges[i], i);
        
        // Sort buildings by descending order of heights.
        Arrays.sort(buildings, (a, b) -> b[2] - a[2]);
        
        // Initalize a disjoin set for all indexs, each index's 
        // root is itself. Since there is no building added yet, 
        // the height at each position is 0.
        int n = edges.length;
        UnionFind edgeUF = new UnionFind(n);
        int[] heights = new int[n];
        
        // Iterate over all the buildings by descending height.
        for (int[] building : buildings) {
            int leftEdge = building[0], rightEdge = building[1];
            int height = building[2];
            
            // For current x position, get the corresponding index.
            int leftIndex = edgeIndexMap.get(leftEdge), rightIndex = edgeIndexMap.get(rightEdge);
            
            // While we haven't update the the root of 'left_idx':
            while (leftIndex < rightIndex) {
                // Find the root of left index 'left_idx', that is:
                // The rightmost index having the same height as 'left_idx'.
                leftIndex = edgeUF.find(leftIndex);

                // If left_idx < right_idx, we have to update both the root and height
                // of 'left_idx', and move on to the next index towards 'right_idx'.
                // That is: increment 'left_idx' by 1.
                if (leftIndex < rightIndex) {
                    edgeUF.union(leftIndex, rightIndex);
                    heights[leftIndex] = height;
                    leftIndex++;
                }
            }
        }
        
        // Finally, we just need to iterate over updated heights, and
        // add every skyline key point to 'answer'.
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (i == 0 || heights[i] != heights[i - 1])
                answer.add(List.of(edges[i], heights[i]));
        }
        return answer; 
    }
}