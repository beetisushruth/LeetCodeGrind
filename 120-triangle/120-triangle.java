class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(Arrays.asList(triangle.get(0).get(0)));
        for(int i=1; i<n; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<i+1; j++) {
                int left = j - 1;
                int right = j;
                int val = triangle.get(i).get(j);
                int sum = Integer.MAX_VALUE;
                if(left >= 0) sum = Math.min(dp.get(i - 1).get(left) + val, sum);
                if(right < i) sum = Math.min(dp.get(i - 1).get(right) + val, sum);
                list.add(sum);
            }
            dp.add(list);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<dp.get(dp.size() - 1).size(); i++) {
            ans = Math.min(ans, dp.get(dp.size() - 1).get(i));
        }
        return ans;
    }
}