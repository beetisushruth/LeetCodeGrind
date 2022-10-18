class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int swapJ = Integer.MIN_VALUE;
        int swapI = -1;
        for(int i=n-1; i>=0; i--) {
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j]) {
                    if(j > swapJ) {
                        swapJ = j;
                        swapI = i;
                    }
                }
            }
        }
        if(swapJ != Integer.MIN_VALUE) {
            int temp = nums[swapI];
            nums[swapI] = nums[swapJ];
            nums[swapJ] = temp;
            sort(nums, swapJ + 1, n - 1);
            return;
        }
        for(int i=0; i<n/2; i++) {
            int temp = nums[n - 1 - i];
            nums[n - 1 - i] = nums[i];
            nums[i] = temp;
        }
        return;
    }
    
    public void sort(int[] arr, int start, int end) {
        
        for(int i=start; i<=end; i++) {
            int min = arr[i];
            int index = i;
            for(int j=i + 1; j<=end; j++) {
                if(min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }
}