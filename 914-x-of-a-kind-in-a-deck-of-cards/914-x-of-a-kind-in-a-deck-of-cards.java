class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        int result = list.get(0);
        for(int i=1; i<list.size(); i++) {
            result = gcd(result, list.get(i));
            if(result == 1) break;
        }
        if(result <= 1) return false;
        return true;
    }
    
    public int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}