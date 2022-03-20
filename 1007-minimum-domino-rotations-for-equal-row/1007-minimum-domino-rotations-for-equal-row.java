class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int num = -1;
        for(int k=1; k<7; k++) {
            boolean match = true;
            for(int i=0; i<tops.length; i++) {
                if(tops[i] != k && bottoms[i] != k) {
                    match = false;
                    break;
                }
            }
            if(match) {
                num = k;
                break;
            }
        }
        if(num == -1) return -1;
        int minCount = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0; i<tops.length; i++) {
            count += (tops[i] == num) ? 1 : 0;
        }
        minCount = Math.min(count, tops.length - count);
        count = 0;
        for(int i=0; i<bottoms.length; i++) {
            count += (bottoms[i] == num) ? 1 : 0; 
        }
        count = Math.min(count, bottoms.length - count);
        return Math.min(count, minCount);
    }
}