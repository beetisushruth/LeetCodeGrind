class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] > 0) nums[Math.abs(nums[i]) - 1] *= -1;
        }
        List<Integer> missing = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) missing.add(i + 1);
        }
        for(int i=0; i<nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] *= -1;
        }
        for(int i=0; i<missing.size(); i++) {
            if(nums[Math.abs(missing.get(i)) - 1] < 0) nums[Math.abs(missing.get(i)) - 1] *= -1;
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] < 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}