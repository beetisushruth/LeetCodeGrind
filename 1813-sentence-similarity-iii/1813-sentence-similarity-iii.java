class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");
        
        if(arr1.length < arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        int[][] dp = new int[n2 + 1][n1 + 1];
        dp[0][0] = 0;
        for(int i=1; i<=n1; i++) {
            dp[0][i] = 1;
        }
        for(int i=1; i<=n2; i++) {
            dp[i][0] = 101;
        }
        for(int r=1; r<=n2; r++) {
            int min = dp[r][0];
            for(int c=1; c<=n1; c++) {
                if(r > c) dp[r][c] = 101;
                String s2 = arr2[r - 1];
                String s1 = arr1[c - 1];
                if(s1.equals(s2)) {
                    dp[r][c] = Math.min(min, dp[r - 1][c - 1]);
                    min = Math.min(min, dp[r][c]);
                } else {
                    dp[r][c] = min + 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[n2][n1] < 2 ? true : false;
    }
}