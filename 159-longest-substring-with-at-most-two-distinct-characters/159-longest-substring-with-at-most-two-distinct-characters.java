class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int count = 0;
        int maxCount = 0;
        int left = 0;
        int[] arr = new int[80];
        for(int i=0; i<s.length(); i++) {
            int index = s.charAt(i) - 'A';
            arr[index]++;
            while(!atMostTwoDistinctChar(arr) && left <= i) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            maxCount = Math.max(maxCount, i - left + 1);
        }
        return maxCount;
    }
    
    public boolean atMostTwoDistinctChar(int[] arr) {
        int count = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0) count++;
        }
        return count <= 2;
    }
}