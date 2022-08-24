class Solution {
    public int largestVariance(String s) {
        
        int ans=0;
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++) freq[s.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j || freq[i]==0 || freq[j]==0) continue;
                int c1freq=0;
                int c2freq=0;
                int c1rem=freq[i];
                for(int k=0;k<s.length();k++){
                    char ch=s.charAt(k);
                    int idx=ch-'a';
                    if(idx==i){
                        c1freq++;
                        c1rem--;
                    }
                    if(idx==j) c2freq++;
                    if(c1freq>c2freq && c1rem>0){
                        c1freq=0;
                        c2freq=0;
                    }
                    
                    if(c2freq>0 && c1freq>0) ans=Math.max(ans,c2freq-c1freq);
                }
            }
        }
        
        return ans;
    }
}