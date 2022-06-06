class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, right = 0;
        List<Integer> temp;
        for(int i=0; i<n; i++) {
            left = i + 1;
            right = n - 1;
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            while(left < right) {
                if(nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else if(nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(right >= 1 && nums[right - 1] == nums[right]) right--;
                    while(left < n - 1 && nums[left + 1]  == nums[left]) left++;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}