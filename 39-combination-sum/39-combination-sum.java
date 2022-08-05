class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        recurse(candidates, new ArrayList<>(), 0, target, 0);
        return ans;
    }
    
    public void recurse(int[] arr, List<Integer> list, int curr, int target, int index) {
        if(curr > target) return;
        if(curr == target) {
            ans.add(new ArrayList<>(list));
        }
        for(int i=index; i<arr.length; i++) {
            if(arr[i] > target) break;
            list.add(arr[i]);
            recurse(arr, list, curr + arr[i], target, i);
            list.remove(list.size() - 1);
        }
    }
}