class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            if(sub.get(sub.size() - 1) < nums[i]) sub.add(nums[i]);
            else {
                int index = binarySearch(sub, nums[i]);
                sub.set(index, nums[i]);
            }
        }
        return sub.size();
    }
    
    public int binarySearch(List<Integer> list, int num) {
        int left = 0;
        int right = list.size() - 1;
        int mid;
        while(left < right) {
            mid = (left + right)/2;
            if(list.get(mid) == num) return mid;
            else if(list.get(mid) > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}