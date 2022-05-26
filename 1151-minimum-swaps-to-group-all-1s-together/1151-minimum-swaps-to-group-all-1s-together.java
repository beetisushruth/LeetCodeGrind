class Solution {
    public int minSwaps(int[] data) {
        // 1 0 1 0 1 1 1 0 0 0 0
        // 0 1 1 1 1 1 0 0 0 0 0 
        int ones = 0;
        for(int i=0; i<data.length; i++) {
            ones += data[i];
        }
        int swaps = 0;
        for(int i=0; i<ones; i++) {
            if(data[i] == 0) swaps++;
        }
        int minSwaps = swaps;
        for(int i=ones; i<data.length; i++) {
            if(data[i] == 0) swaps++;
            if(data[i - ones] == 0) swaps--;
            minSwaps = Math.min(swaps, minSwaps);
        }
        return minSwaps;
    }
}