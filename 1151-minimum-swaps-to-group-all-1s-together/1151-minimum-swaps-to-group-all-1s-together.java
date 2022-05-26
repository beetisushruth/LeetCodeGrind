class Solution {
    public int minSwaps(int[] data) {
        // 1 0 1 0 1 1 1 0 0 0 0
        // 0 1 1 1 1 1 0 0 0 0 0 
        int ones = 0;
        for(int i=0; i<data.length; i++) {
            ones += data[i];
        }
        int swaps = 0;
        int minSwaps = data.length;
        for(int i=0; i<data.length; i++) {
            if(data[i] == 0) swaps++;
            if(i >= ones) {
                if(data[i - ones] == 0) swaps--;
            }
            if(i >= ones - 1) minSwaps = Math.min(swaps, minSwaps);
        }
        return minSwaps;
    }
}