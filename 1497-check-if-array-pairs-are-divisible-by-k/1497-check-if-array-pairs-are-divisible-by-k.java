class Solution {
    public boolean canArrange(int[] arr, int k) {
        int arrSize = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arrSize; i++) {
            int key = arr[i] % k < 0 ? k + (arr[i] % k) : arr[i] % k;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        // System.out.println(map);
        for(int r : map.keySet()) {
            if(r == 0) {
                if(map.get(0) % 2 != 0) return false;
                continue;
            }
            if(!map.containsKey(k - r) || !map.get(r).equals(map.get(k - r))) return false;
        }
        return true;
    }
}

/**
arr = [1,2,3,4,5,10,6,7,8,9] k = 5
int arrSize = 10;
{
    1: 2
    2: 2
    3: 2
    4: 2
    0: 2
}



*/