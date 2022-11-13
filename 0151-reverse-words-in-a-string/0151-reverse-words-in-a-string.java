class Solution {
    public String reverseWords(String s) {
        s = s.strip();
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=words.length - 1; i>=0; i--) {
            if(!words[i].equals("")) {
                sb.append(words[i]);
                if(i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
    
}