class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        ans.add(row1);
        for(int i=0; i<numRows-1; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=0; j<i; j++) {
                row.add(ans.get(i).get(j) + ans.get(i).get(j + 1));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}