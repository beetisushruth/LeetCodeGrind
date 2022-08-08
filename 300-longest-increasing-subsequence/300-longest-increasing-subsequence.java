class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int max = 0;
        for(int num : nums) {
            if(arr.size() == 0 || arr.get(arr.size() - 1) < num) {
                arr.add(num);
            } else {
                int index = binarySearch(arr, num);
                arr.set(index, num);
            }
            max = Math.max(max, arr.size());
        }
        return max;
    }
    
    public int binarySearch(List<Integer> nums, int num) {
        int start = 0;
        int end = nums.size() - 1;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(nums.get(mid) >= num) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}