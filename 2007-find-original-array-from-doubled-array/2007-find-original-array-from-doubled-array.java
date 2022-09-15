class Solution {
    
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 != 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : changed) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(changed);
        int[] arr = new int[n/2];
        int j = 0;
        for(int num : changed) {
            if(map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                if(map.containsKey(num*2) && map.get(2*num) > 0) {
                    map.put(num*2, map.get(num*2) - 1);
                    arr[j++] = num;
                } else {
                    return new int[0];
                }
            }
        }
        return arr;
    }
}