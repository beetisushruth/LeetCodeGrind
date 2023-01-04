class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int total = 0;
        for(int key : map.keySet()) {
            int num = map.get(key);
            if(num < 2) return -1; 
            total += (num % 3 == 0 ? (num / 3) : (num / 3) + 1);
        }
        return total;
    }
}