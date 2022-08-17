class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for(String word : words) {
            String code = "";
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                code += codes[c - 'a'];
            }
            set.add(code);
        }
        return set.size();
    }
    
}