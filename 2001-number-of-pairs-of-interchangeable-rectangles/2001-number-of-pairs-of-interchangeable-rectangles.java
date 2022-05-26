class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Long> map = new HashMap<>();
        for(int i=0; i<rectangles.length; i++) {
            double width = (double) rectangles[i][0];
            double height = (double) rectangles[i][1];
            double ratio = width/height;
            map.put(ratio, map.getOrDefault(ratio, (long) 0) + 1);
        }
        long count = 0;
        for(double key : map.keySet()) {
            if(map.get(key) > 1) {
                long n = map.get(key);
                count += (n * (n - 1))/2;
            }
        }
        return count;
    }
}