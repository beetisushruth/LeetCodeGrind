class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        char prev = colors.charAt(0);
        int total = neededTime[0];
        int max = neededTime[0];
        int timeTaken = 0;
        for(int i=1; i<n; i++) {
            if(prev == colors.charAt(i)) {
                total += neededTime[i];
                max = Math.max(max, neededTime[i]);
            } else {
                // System.out.println(total+" "+max);
                timeTaken += total - max;
                total = neededTime[i];
                max = neededTime[i];
                prev = colors.charAt(i);
            }
        }
        return timeTaken + total - max;
    }
}