class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> {
           if(a[0] != b[0]) return a[0] - b[0];
           return a[1] - b[1];
        });
        Arrays.sort(slots2, (a, b) -> {
           if(a[0] != b[0]) return a[0] - b[0];
           return a[1] - b[1];
        });
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while(i < slots1.length && j < slots2.length) {
            int overlap = Math.min(slots1[i][1], slots2[j][1]) - Math.max(slots1[i][0], slots2[j][0]);
            // System.out.println(i+" "+j+" "+overlap);
            if(slots1[i][1] < slots2[j][0]) {
                i++;
            } else if(slots2[j][1] < slots1[i][0]) {
                j++;
            } else if(overlap < duration) {
                if(slots1[i][1] < slots2[j][1]) i++;
                else j++;
            } else {
                ans.add(Math.max(slots1[i][0], slots2[j][0]));
                ans.add(Math.max(slots1[i][0], slots2[j][0]) + duration);
                break;
            }
        }
        return ans;
    }
}