class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int total = 0;
        int[] arr = new int[properties.length];
        Arrays.sort(properties, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        int max = properties[0][1];
        for(int i=1; i<properties.length; i++) {
            if(properties[i][1] < max) total++;
            else max = properties[i][1];
        }
        return total;
    }
}