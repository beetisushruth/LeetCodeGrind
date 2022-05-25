class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // 2 3   1   1 3
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] secondDim = new int[n];
        for(int i=0; i<n; i++) {
            secondDim[i] = envelopes[i][1];
        }
        return lis(secondDim);
    }
    
    public int lis(int[] arr) {
        List<Integer> sub = new ArrayList<>();
        sub.add(arr[0]);
        for(int i=1; i<arr.length; i++) {
            if(sub.get(sub.size() - 1) < arr[i]) sub.add(arr[i]);
            else {
                int index = binarySearch(sub, arr[i]);
                sub.set(index, arr[i]);
            }
        }
        return sub.size();
    }
    
    public int binarySearch(List<Integer> sub, int num) {
        int n = sub.size();
        int left = 0, right = n - 1;
        int mid = 0;
        while(left < right) {
            mid = (left + right)/2;
            if(sub.get(mid) >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}