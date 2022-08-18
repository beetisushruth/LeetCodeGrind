class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> freq = new ArrayList<>();
        for(int value : map.values()) freq.add(value);
        Collections.sort(freq);
        int count = 0;
        int half = (arr.length + 1)/2;
        for(int i=freq.size() - 1; i>=0; i--) {
            if(half <= 0) break;
            half -= freq.get(i);
            count++;
        }
        return count;
    }
}