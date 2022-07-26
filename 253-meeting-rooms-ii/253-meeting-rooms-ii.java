class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, intervals[i][1]);
        }
        int[] arr = new int[max + 1];
        for(int i=0; i<n; i++) {
            arr[intervals[i][0]]++;
            arr[intervals[i][1]]--;
        }
        max = 0;
        for(int i=1; i<arr.length; i++) {
            arr[i] += arr[i - 1];
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}