class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains) {
            String[] cpdomainArr = cpdomain.split(" ");
            int count = Integer.parseInt(cpdomainArr[0]);
            String[] subdomains = cpdomainArr[1].split("\\.");
            String subdomain = "";
            for(int i=subdomains.length - 1; i>=0; i--) {
                subdomain = subdomain.length() == 0 ? subdomains[i] : subdomains[i] + "."+ subdomain;
                map.put(subdomain, map.getOrDefault(subdomain, 0) + count);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String key : map.keySet()) {
            ans.add(map.get(key)+" "+key);
        }
        return ans;
    }
}