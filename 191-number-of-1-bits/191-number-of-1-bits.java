public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // return Integer.bitCount(n);
        int i = 32;
        int num = 1;
        int count = 0;
        while(i > 0) {
            if((n & num) != 0) count++;
            num <<= 1;
            i--;
        }
        return count;
    }
}