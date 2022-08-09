class Solution {
    public int MOD = (int) Math.pow(10, 9) + 7;
    
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Integer> dp = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int num : arr) set.add(num);
        long total = 0;
        for(int i=0; i<arr.length; i++) {
            long value = getBinaryTrees(arr, set, dp, arr[i])%MOD;
            total =  (total%MOD + value%MOD)%MOD;
        }
        return (int) total;
    }
    
    public int getBinaryTrees(int[] arr, Set<Integer> set, Map<Integer, Integer> map, int num) {
        if(map.containsKey(num)) return map.get(num);
        long count = 1;
        for(int i=0; i<arr.length; i++) {
            if(num%arr[i] == 0 && set.contains(num/arr[i])) {
                long left = getBinaryTrees(arr, set, map, arr[i])%MOD;
                long right = getBinaryTrees(arr, set, map, num/arr[i])%MOD;
                count = (count%MOD + (left*right)%MOD)%MOD;
            }
        }
        map.put(num, (int) count);
        return (int) count;
    }
}