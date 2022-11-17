class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int a1 = area(ax1, ay1, ax2, ay2);
        int a2 = area(bx1, by1, bx2, by2);
        int a3 = 0;
        if(isoverlap(ax1, ax2, bx1, bx2) && isoverlap(ay1, ay2, by1, by2)) {
            a3 = area(Math.max(ax1, bx1), Math.max(ay1, by1), Math.min(ax2, bx2), Math.min(ay2, by2));
        }
        return a1 + a2 - a3;
    }
    public boolean isoverlap(int a1, int a2, int a3, int a4) {
        return !((a2 <= a3 && a2 <= a4) || (a1 >= a3 && a1 >= a4));
    }
    
    public int area(int x1, int y1, int x2, int y2) {
        return (x2 - x1)*(y2 - y1);
    }
}