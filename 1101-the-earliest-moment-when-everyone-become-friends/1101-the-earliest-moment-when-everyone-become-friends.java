class Solution {
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> temp;
        for(int i=0; i<logs.length; i++) {
            int a = logs[i][1];
            int b = logs[i][2];
            Set<Integer> s1 = findSet(list, a);
            Set<Integer> s2 = findSet(list, b);
            if(s1 == null && s2 == null) {
                temp = new HashSet<>();
                temp.add(a);
                temp.add(b);
                list.add(temp);
            } else if(s1 == null) {
                s2.add(a);
                list.add(s2);
            } else if(s2 == null) {
                s1.add(b);
                list.add(s1);
            } else {
                s1.addAll(s2);
                list.add(s1);
            }
            if(list.get(0).size() == n) return logs[i][0];
        }
        return -1;
    }
    
    public Set<Integer> findSet(List<Set<Integer>> list, int a) {
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).contains(a)) {
                return list.remove(i);
            }
        }
        return null;
    }
}