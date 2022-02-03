class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int a = nums1.length;
        int b = nums2.length; 
        int c = nums3.length; 
        int d = nums4.length;
        long[] nums12 = new long[a*b];
        long[] nums34 = new long[c*d];
        fillArray(nums1, nums2, nums12);
        fillArray(nums3, nums4, nums34);
        return findCount(nums12, nums34);
    }
    
    public void fillArray(int[] nums1, int[] nums2, long[] nums) {
        int k = 0;
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                nums[k] = nums1[i] + nums2[j];
                k++;
            }
        }
    }
    
    public int findCount(long[] a, long[] b) {
        int count = 0;
        Map<Long, Integer> mapA = new HashMap<>();
        Map<Long, Integer> mapB = new HashMap<>();
        for(long num : a) {
            mapA.put(num, mapA.getOrDefault(num, 0) + 1);
        }
        for(long num : b) {
            mapB.put(num, mapB.getOrDefault(num, 0) + 1);
        }
        for(long key : mapA.keySet()) {
            if(mapB.containsKey(-key)) {
                count += (mapA.get(key) * mapB.get(-key));
            }
        }
        return count;
    }
}