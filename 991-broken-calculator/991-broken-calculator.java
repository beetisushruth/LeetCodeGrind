class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue >= target) return startValue - target;
        int count = 0;
        if(target%2 == 1) {
            count = 1 + brokenCalc(startValue, target + 1);
        } else {
            count = 1 + brokenCalc(startValue, target/2);
        }
        return count;
    }
}
// 2  -> 4 - 8 - 7 - 14 - 13