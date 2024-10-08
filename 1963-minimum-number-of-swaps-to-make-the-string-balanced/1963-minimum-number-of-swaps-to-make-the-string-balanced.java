class Solution {
    public int minSwaps(String s) {
        int n = 0;
        for(char c : s.toCharArray()) {
            if(c == '[') n++;
            else if(n > 0) n--;
        }
        return (int) Math.ceil((double) n / 2);
    }
}