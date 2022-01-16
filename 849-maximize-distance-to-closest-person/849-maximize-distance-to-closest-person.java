class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int left = 0, right = n - 1;
        while(seats[left] == 0) {
            left++;
        }
        while(seats[right] == 0) {
            right--;
        }
        int max = Math.max(left, n - 1 - right);
        int count = 0;
        for(int i=left; i<=right; i++) {
            if(seats[i] == 0) {
                count++;
            } else {
                max = Math.max(max, count%2 == 0 ? count/2 : count/2 + 1);
                count = 0;
            }
        }
        return max;
    }

    // public int maxDistToClosest(int[] seats) {
    //     int n = seats.length;
    //     int[] arr = new int[n];
    //     for(int i=0; i<arr.length; i++) arr[i] = n;
    //     int left = -1;
    //     int right = -1;
    //     for(int i=0; i<n; i++) {
    //         if(seats[i] == 1) left = i;
    //         if(seats[n - 1 - i] == 1) right = n - i - 1;
    //         if(left >= 0 && seats[i] != 1) {
    //             arr[i] = Math.min(i - left, arr[i]);
    //         }
    //         if(right >= 0 && seats[n - i - 1] != 1) {
    //             arr[n - i - 1] = Math.min(right - (n - i - 1), arr[n - i - 1]);
    //         }
    //     }
    //     int max = 0;
    //     for(int i = 0; i<n; i++) {
    //         if(arr[i] != n) {
    //             max = Math.max(max, arr[i]);
    //         }
    //     }
    //     return max;
    // }
}