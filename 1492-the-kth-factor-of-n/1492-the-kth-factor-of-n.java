class Solution {
    public int kthFactor(int n, int k) {
        if(k == 1) return 1;
        k--;
        for(int i=2; i<=n; i++) {
            if(n%i == 0) k--;
            if(k == 0) return i;
        }
        return -1;
    }
}