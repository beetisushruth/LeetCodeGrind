class Solution {
    public int getMaxLen(int[] nums) {
        int maxCount = 0;
        int n = nums.length;
        for(int i=0, neg=0, fst = -1, count = 0; i<n; i++) {
            if(nums[i] == 0) {
                neg = 0;
                count = 0;
                fst = -1;
            } else if(nums[i] < 0) {
                neg++;
                if(fst == -1) fst = i;
                count++;
            } else {
                count++;
            }
            
            if(neg%2 == 0) {
                maxCount = Math.max(count, maxCount);
            } else {
                maxCount = Math.max(maxCount, i - fst);
            }
        }
        return maxCount;
    }
}