class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        boolean[] arr = new boolean[n];
        arr[0] = false;
        int min = nums[0];
        for(int i=1; i<n; i++) {
            if(nums[i] > min) {
                arr[i] = true;
            } else {
                arr[i] = false;
                min = nums[i];
            }
        }
        //System.out.println(Arrays.toString(arr));
        int max = nums[n - 1];
        for(int i=n-2; i>=0; i--) {
            if(nums[i] < max) {
                if(arr[i]) return true;
            }
            else max = nums[i];
        }
        return false;
    }
}