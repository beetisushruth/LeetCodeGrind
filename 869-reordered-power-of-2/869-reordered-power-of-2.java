class Solution {
    public boolean reorderedPowerOf2(int n) {
        int num = 1;
        int count = 0;
        while(count < 30) {
            if(isMatch(num, n)) return true;
            num *= 2;
            count++;
        }
        return false;
    }
    
    public boolean isMatch(int num, int n) {
        int[] arr = new int[10];
        String s = Integer.toString(num);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            arr[c - '0']++;
        }
        s = Integer.toString(n);
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            arr[c - '0']--;
        }
        for(int i=0; i<=9; i++) {
            if(arr[i] != 0) return false;
        }
        return true;
    }
}