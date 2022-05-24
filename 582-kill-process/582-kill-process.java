class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<ppid.size(); i++) {
            int child = pid.get(i);
            int parent = ppid.get(i);
            List<Integer> children = map.containsKey(parent) ? map.get(parent) : new ArrayList<Integer>();
            children.add(child);
            map.put(parent, children);
        }
        List<Integer> ans = new ArrayList<>();
        dfs(kill, map, ans);
        return ans;
    }
    
    public void dfs(int kill, Map<Integer, List<Integer>> map, List<Integer> ans) {
        ans.add(kill);
        if(map.containsKey(kill)) {
            List<Integer> children = map.get(kill);
            for(int i=0; i<children.size(); i++) {
                dfs(children.get(i), map, ans);
            }
        }
    }
}