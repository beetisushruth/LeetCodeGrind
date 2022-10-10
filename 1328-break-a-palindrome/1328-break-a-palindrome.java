class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1) return "";
        char[] arr = palindrome.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n/2) {
            char c = palindrome.charAt(i);
            if(c != 'a') {
                arr[i] = 'a';
                return new String(arr);
            } 
            i++;
        }
        arr[n - 1] = 'b';
        return new String(arr);
    }
}