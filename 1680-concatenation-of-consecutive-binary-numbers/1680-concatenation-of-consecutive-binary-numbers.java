class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            String s = Integer.toBinaryString(i);
            sb.append(s);
        }
        String s = sb.toString();
        int bin = 1;
        int total = 0;
        for(int i=s.length() - 1; i>=0; i--) {
            int bit = s.charAt(i) - '0';
            total = (total + bin*bit)%MOD;
            long temp = bin * 2;
            bin = (int) temp%MOD;
        }
        return total;
    }
}