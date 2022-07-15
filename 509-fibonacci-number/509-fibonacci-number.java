class Solution {
    public int fib(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0); map.put(1, 1);
        return recurse(n, map);
    }
    
    public int recurse(int n, Map<Integer, Integer> map) {
        if(map.containsKey(n)) return map.get(n);
        int ans = recurse(n - 1, map) + recurse(n - 2, map);
        map.put(n, ans);
        return ans;
    } 
}