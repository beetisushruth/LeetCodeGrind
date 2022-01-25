class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int i = 1;
        if(arr[0] >= arr[1]) return false;
        while(i < arr.length) {
            if(arr[i - 1] > arr[i]) break;
            if(arr[i - 1] == arr[i]) return false;
            i++;
        }
        if(i >= arr.length) return false;
        while(i < arr.length) {
            if(arr[i - 1] <= arr[i]) return false;
            i++;
        }
        return true;
    }
}