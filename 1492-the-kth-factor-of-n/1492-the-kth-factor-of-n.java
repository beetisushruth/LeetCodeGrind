class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int sq = (int) Math.sqrt(n);
        for(int i=1; i<=sq; i++) {
            if(n % i == 0) {
                list1.add(i);
                if(i != n/i) {
                    list2.add(n/i);
                }
            }
        }
        if(k <= list1.size()) {
            return list1.get(k - 1);
        }
        k = k - list1.size();
        if(k <= list2.size()) {
            return list2.get(list2.size() - k);
        }
        return -1;
    }
}