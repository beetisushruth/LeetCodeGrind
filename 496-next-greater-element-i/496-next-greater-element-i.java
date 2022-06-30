class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 1 3 4 2
        // 5 4 3 1 2
        // 2
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        st.add(nums2[0]);
        for(int i=0; i<nums2.length; i++) {
            while(!st.isEmpty() && st.peek() < nums2[i]) {
                map.put(st.pop(), nums2[i]);
            }
            st.add(nums2[i]);
        }
        for(int i=0; i<nums1.length; i++) {
            nums1[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        return nums1;
    }
}