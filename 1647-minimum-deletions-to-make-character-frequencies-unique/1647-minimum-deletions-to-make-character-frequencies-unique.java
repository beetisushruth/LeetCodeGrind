class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] arr = new int[26];
        SortedSet<Integer> sset = new TreeSet<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<26; i++) {
            if(arr[i] > 0) sset.add(arr[i]);
        }
        int count = 0;
        for(int i=0; i<26; i++) {
            if(set.contains(arr[i]) && arr[i] > 0) {
                int freq = arr[i];
                while(sset.contains(freq)) {
                    freq--;
                }
                count += arr[i] - freq;
                if(freq > 0) sset.add(freq);
            }
            set.add(arr[i]);
        }
        return count;
    }
}