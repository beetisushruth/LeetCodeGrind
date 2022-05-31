class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=k-1; i<s.length(); i++) {
            String code = s.substring(i - k + 1, i + 1);
            int num = Integer.parseInt(code, 2);
            set.add(num);
        }
        int pow = (int) Math.pow(2, k);
        for(int i=0; i<pow; i++) {
            if(!set.contains(i)) return false;
        }
        return true;
    }
}