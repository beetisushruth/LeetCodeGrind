class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                map.put(nums1[i]+ nums2[j], map.getOrDefault(nums1[i]+nums2[j], 0) + 1);
            }
        }
        for(int i=0; i<nums3.length; i++) {
            for(int j=0; j<nums4.length; j++) {
                if(map.containsKey(-(nums3[i]+nums4[j]))) {
                    count += map.get(-(nums3[i]+nums4[j]));
                }
            }
        }
        return count;
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