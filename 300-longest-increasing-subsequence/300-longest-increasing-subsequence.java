class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            if(sub.get(sub.size() - 1) < nums[i]) {
                sub.add(nums[i]);
            } else {
                int index = binarySearch(sub, nums[i]);
                sub.set(index, nums[i]);
            }
        }
        return sub.size();
    }
    
    public int binarySearch(List<Integer> sub, int num) {
        int size = sub.size();
        int left = 0;
        int right = size - 1;
        int mid = (left + right)/2;
        while(left < right) {
            mid = (left + right)/2;
            if(sub.get(mid) >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}