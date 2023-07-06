class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] bags = new int[k];
        return recurse(cookies, 0, bags, k);
    }
    
    public int recurse(int[] cookies, int i, int[] bags, int k) {
        if(i >= cookies.length) {
            int max = 0;
            for(int j=0; j<bags.length; j++) {
                max = Math.max(max, bags[j]);
            }
            return max;
        }
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<k; j++) {
            bags[j] += cookies[i];
            int maxCookies = recurse(cookies, i + 1, bags, k);
            bags[j] -= cookies[i];
            ans = Math.min(maxCookies, ans);
        }
        return ans;
    }
}