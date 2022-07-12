import java.util.Arrays;

class Solution {
    
    public boolean makesquare(int[] matchsticks) {
        int[] sides = new int[4];
        List<Integer> nums = new ArrayList<>();
        for(int match : matchsticks) {
            nums.add(match);
        }
        Collections.sort(nums, Collections.reverseOrder());
        for(int i=0; i<matchsticks.length; i++) matchsticks[i] = nums.get(i);
        int length = 0;
        for(int i=0; i<matchsticks.length; i++) {
            length += matchsticks[i];
        }
        if(length%4 != 0) return false;
        length /= 4;
        return recurse(matchsticks, sides, 0, length);
    }
    
    public boolean recurse(int[] matchsticks, int[] sides, int j, int length) {
        if(j == matchsticks.length) {
            for(int i=0; i<4; i++) if(sides[i] != length) return false;
            return true;
        }
        boolean ans = false;
        for(int i=0; i<4; i++) {
            sides[i] += matchsticks[j];
            ans = sides[i] <= length ? recurse(matchsticks, sides, j + 1, length) : false;
            if(ans) return true;
            sides[i] -= matchsticks[j];
        }
        return ans;
    }
}