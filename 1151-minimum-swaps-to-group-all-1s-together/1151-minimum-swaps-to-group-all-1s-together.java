class Solution {
    public int minSwaps(int[] data) {
        int ones = 0;
        for(int num : data) {
            if(num == 1) ones++;
        }
        int count = 0;
        for(int i=0; i<ones; i++) {
            count += (data[i] == 0 ? 1 : 0); 
        }
        int minCount = count;
        for(int i=ones; i<data.length; i++) {
            count -= (data[i - ones] == 0 ? 1 : 0);
            count += (data[i] == 0 ? 1 : 0);
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }
}