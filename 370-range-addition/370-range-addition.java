class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int i=0; i<updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int inc = updates[i][2];
            res[start] += inc;
            if(end + 1 < length) res[end + 1] -= inc;
        }
        for(int i=1; i<res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }
}