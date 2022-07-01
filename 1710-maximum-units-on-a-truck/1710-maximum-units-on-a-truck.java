class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int units = 0;
        int i = 0;
        while(truckSize > 0 && i < boxTypes.length) {
            int boxes = Math.min(truckSize, boxTypes[i][0]);
            truckSize -= boxes;
            units += boxes*boxTypes[i][1];
            i++;
        }
        return units;
    }
}