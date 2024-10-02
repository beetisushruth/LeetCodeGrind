class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int[] sortedArr = new int[n];
        for(int i = 0; i < n; i++) {
            sortedArr[i] = arr[i];
        }
        Arrays.sort(sortedArr);
        int rank = 0;
        for(int i=0; i < n ; i++) {
            if(!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], rank + 1);
                rank++;
            }
        }
        for(int i=0; i<n; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}

