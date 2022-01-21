class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int start = 1;
        int end = 0;
        for(int i : piles) end = Math.max(end, i);
        int mid;
        while(start < end) {
            mid = start + (end - start)/2;
            if(getHours(piles, mid) > h) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    public int getHours(int[] piles, int k) {
        int hours = 0;
        for(int i=0; i<piles.length; i++) {
            int h = (int) Math.ceil(((double) piles[i]/ (double) k));
            hours += h;
        }
        return hours;
    }
}