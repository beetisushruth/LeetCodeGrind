class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] arr = new int[26];
            for(int i=0; i<str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            String key = "";
            for(int i=0; i<arr.length; i++) {
                key += arr[i]+" ";
            }
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;
    }
}