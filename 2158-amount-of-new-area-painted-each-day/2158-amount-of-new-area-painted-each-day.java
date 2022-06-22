class Solution {
    public int[] amountPainted(int[][] paint) {
        int[] arr = new int[100001];
        int[] res = new int[paint.length];
        for(int i=0; i<paint.length; i++) {
            int count = 0;
            for(int j=paint[i][0]; j<paint[i][1]; j++) {
                if(arr[j] == 0) {
                    arr[j] = 1;
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}