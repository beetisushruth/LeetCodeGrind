class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<10; i++) {
            recurse(n - 1, k, i, list);
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
    
    public void recurse(int n, int k, int curr, List<Integer> list) {
        if(n == 0) {
            list.add(curr);
            return;
        }
        int lastDigit = curr%10;
        if(lastDigit - k >= 0) {
            recurse(n - 1, k, curr*10 + lastDigit - k, list);
        }
        if(k != 0 && lastDigit + k <= 9) {
            recurse(n - 1, k, curr*10 + lastDigit + k, list);
        }
    }
}