class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0, maxCount = 0;
        while(right < n) {
            int type = fruits[right];
            while(left < right && map.size() >= 2 && !map.containsKey(type)) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
                count--;
            }
            if(map.size() < 2 || (map.containsKey(type))) {
                map.put(type, map.getOrDefault(type, 0) + 1);
                right++;
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}