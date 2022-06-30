class Solution {
    int MOD = (int)Math.pow(10,9) + 7;
    public int countHousePlacements(int n) {
        if(n == 1) return 4;
        if(n == 2) return 9;
        long num1 = 2; long num2 = 3;
        for(int i=2; i<n; i++) {
            long temp = num2;
            num2 = (num1 + num2)%MOD;
            num1 = temp;
        }
        return (int)((num2*num2)%MOD);
    }
}