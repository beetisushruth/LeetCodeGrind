class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int left = 0, right = l - 1;
        while(left < l && flowerbed[left] == 0) left++;
        n -= (left)/2;
        while(right >= 0 && left <= right && flowerbed[right] == 0) right--;
        n -= (l - right - 1)/2;
        if(left == l && left%2 == 1) n--;
        int count = 0;
        while(left <= right) {
            if(flowerbed[left] == 0) count++;
            else if(count > 0) {
                n -= (count%2 == 0 ? count/2 - 1 : count/2);
                count = 0;
            }
            left++;
        }
        return n<=0 ;
    }
}