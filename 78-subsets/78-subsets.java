class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recurse(nums, new ArrayList<>(), 0);
        return ans;
    }
    
    public void recurse(int[] nums, List<Integer> list, int i) {
        if(i >= nums.length) {
            ans.add(list);
        } else {
            List<Integer> temp = cloneList(list);
            temp.add(nums[i]);
            recurse(nums, temp, i + 1);
            recurse(nums, list, i + 1);
        }
    }
    
    public List<Integer> cloneList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();
        for(int i=0; i<list.size(); i++) {
            newList.add(list.get(i));
        }
        return newList;
    }
}