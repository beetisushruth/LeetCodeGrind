class Solution {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long[] reg = new long[n + 1];
        long[] exp = new long[n + 1];
        exp[0] = expressCost;
        for(int i=1; i<=n; i++) {
            reg[i] = reg[i - 1] + regular[i - 1];
            exp[i] = exp[i - 1] + express[i - 1];
            long temp = Math.min(reg[i], exp[i]);
            exp[i] = Math.min(exp[i], reg[i] + expressCost);
            reg[i] = temp;
        }
        //System.out.println(Arrays.toString(reg));
        //System.out.println(Arrays.toString(exp));
        long[] ans = new long[n];
        for(int i=1; i<=n; i++) {
            ans[i - 1] = Math.min(reg[i], exp[i]);
        }
        return ans;
    }
     
}