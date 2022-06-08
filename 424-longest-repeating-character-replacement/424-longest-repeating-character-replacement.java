class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int[] arr = new int[26];
        while(left <= right && right < s.length()) {
            arr[s.charAt(right) - 'A']++;
            while(left <= right && numOfDiffs(arr) > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    
    }
    
    public int numOfDiffs(int[] arr) {
        int count = 0;
        int max = 0;
        for(int num : arr) {
            count += num;
            max = Math.max(max, num);
        }
        return count - max;
    }
}