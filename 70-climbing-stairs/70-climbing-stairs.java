class Solution {
    public int climbStairs(int n) {
        if(n < 2) return 1;
        int left = 1; int right = 1;
        for(int i=2; i<=n; i++) {
            int temp = right;
            right = left + right;
            left = temp;
        }
        return right;
    }
}