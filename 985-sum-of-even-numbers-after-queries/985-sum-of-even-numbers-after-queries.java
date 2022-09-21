class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] ans = new int[n];
        int m = queries.length;
        int sumE = 0 ;
        for(int i: nums){
            if(i%2==0) {
                sumE+=i;
            }
        }
        int j = 0;
        for(int i=0; i<n; i++){
            j = queries[i][1];
            if(nums[j]%2==0) {
                sumE-=nums[j];
            }
            nums[j]+=queries[i][0];
            if(nums[j]%2==0) {
                sumE+=nums[j];
            }
            ans[i] = sumE;
        }
        return ans;
    }
}