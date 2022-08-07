class Solution {
    Map<String, Long> dp = new HashMap<>();
    public static int MOD = (int) Math.pow(10, 9) + 7;
    
    public int countVowelPermutation(int n) {
        long total = 0;
        String s = "aeiou";
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            total = (total + recurse(c, n)%MOD)%MOD;
        }
        return (int) total;
    }
    
    public long recurse(char prev, int n) {
        if(n == 1) return 1;
        String key = prev+" "+n;
        if(dp.containsKey(key)) return dp.get(key);
        if(prev == 'a') {
            dp.put(key,  recurse('e', n - 1)%MOD);
            return dp.get(key);
        } else if(prev == 'e') {
            dp.put(key, (recurse('a', n - 1)%MOD + recurse('i', n - 1)%MOD)%MOD);
            return dp.get(key); 
        } else if(prev == 'o') {
            dp.put(key, (recurse('i', n - 1)%MOD + recurse('u', n - 1)%MOD));
            return dp.get(key);
        } else if(prev == 'u') {
            dp.put(key, recurse('a', n - 1)%MOD);
            return dp.get(key);
        }
        dp.put(key, (recurse('a', n - 1)%MOD + recurse('e', n - 1)%MOD + recurse('o', n - 1)%MOD + recurse('u', n - 1)%MOD)%MOD);
        return dp.get(key);
    }
}