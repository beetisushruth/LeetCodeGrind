class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int left = 0, right = 0;
        List<Integer> temp;
        for(int i=0; i<n; i++) {
            left = i + 1;
            right = n - 1;
            while(left < right) {
                if(nums[left] + nums[right] > -nums[i]) {
                    right--;
                } else if(nums[left] + nums[right] < -nums[i]) {
                    left++;
                } else {
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    Collections.sort(temp);
                    set.add(temp);
                    left++;
                    right--;
                }
            }
        }
        for(List<Integer> l : set) {
            ans.add(l);
        }
        return ans;
    }
}