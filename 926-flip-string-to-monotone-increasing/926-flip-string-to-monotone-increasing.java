class Solution {
    public int minFlipsMonoIncr(String s) {
        int zeroes = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') zeroes += 1;
        }
        int ones = 0;
        int flips = zeroes;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1') ones++;
            else zeroes--;
            flips = Math.min(flips, ones + zeroes);
        }
        return flips;
    }
}