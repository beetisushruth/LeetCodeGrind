class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse)    {
        Arrays.sort(boxes);
        boolean[] used = new boolean[boxes.length];
        int[] heights = new int[warehouse.length];
        heights[0] = warehouse[0];
        int minHeight = heights[0];
        for(int i=1; i<warehouse.length; i++) {
            minHeight = Math.min(minHeight, warehouse[i]);
            heights[i] = minHeight;
        }
        int count = 0;
        for(int i=0; i<warehouse.length; i++) {
            int box = findBox(boxes, used, warehouse[i], heights[i]);
            if(box != -1) count++;
        }
        return count;
    }
    
    public int findBox(int[] boxes, boolean[] used, int height, int minHeight) {
        int left = 0;
        int right = boxes.length - 1;
        int ans = -1;
        while(left <= right) {
            int mid = (left + right)/2;
            if(boxes[mid] > minHeight) right = mid - 1;
            else if(boxes[mid] < minHeight && boxes[mid] > height) right = mid - 1;
            else if(used[mid]) right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }
        }
        if(ans == -1) return -1;
        used[ans] = true;
        return boxes[ans];
    }
}