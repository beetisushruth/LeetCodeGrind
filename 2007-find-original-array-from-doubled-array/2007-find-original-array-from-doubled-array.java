class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        
        int[] counts = new int[100001];
        
        for (int val : changed) counts[val]++;
        
        int[] orig = new int[changed.length / 2];
        int curr = 0;
        
        if (counts[0] % 2 == 0) {
            curr = counts[0] / 2;            
        } else {
            return new int[0];
        }
        
        for (int i = 1; i <= 100000; i++) {
            if (counts[i] > 0) {
                if (i > 50000 || counts[i*2] < counts[i] || counts[i] + curr > orig.length) {
                    return new int[0];
                } else {
                    for (int j = 0; j < counts[i]; j++) {
                        counts[i*2]--;
                        orig[curr++] = i;
                    }
                }
            }
        }
        
        return orig;
    }
}