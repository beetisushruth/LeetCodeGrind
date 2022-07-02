class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int M = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHeight = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        for(int i=1; i<horizontalCuts.length; i++) {
            maxHeight = Math.max(horizontalCuts[i] - horizontalCuts[i - 1], maxHeight);
        }
        // System.out.println(maxHeight);
        int maxWidth = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for(int i=1; i<verticalCuts.length; i++) {
            maxWidth = Math.max(verticalCuts[i] - verticalCuts[i - 1], maxWidth);
        }
        return (int)((long) maxHeight*maxWidth%M);
    }
}