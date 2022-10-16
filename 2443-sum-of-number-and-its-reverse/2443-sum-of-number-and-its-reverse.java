class Solution {
    static Set<Integer> set = new HashSet<>();
    static {
        for(int i=0; i<=100000; i++) {
            int rev = 0;
            int num = i;
            while(num > 0) {
                rev = rev*10 + num%10;
                num /= 10;
            }
            set.add(i + rev);
        }
    }
    public boolean sumOfNumberAndReverse(int num) {
        return set.contains(num);
    }
}