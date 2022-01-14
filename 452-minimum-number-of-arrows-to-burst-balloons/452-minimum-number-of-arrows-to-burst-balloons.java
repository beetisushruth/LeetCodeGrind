class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        Stack<int[]> st = new Stack<>();
        for(int i=0; i<points.length; i++) {
            int[] point = points[i];
            if(!st.isEmpty() && st.peek()[1] >= point[0]) {
                int[] lastPoint = st.pop();
                st.push(new int[]{point[0], Math.min(lastPoint[1], point[1])});
            } else {
                st.push(point);
            }
        }
        return st.size();
    }
}