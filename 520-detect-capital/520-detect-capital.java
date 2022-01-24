class Solution {
    public boolean detectCapitalUse(String word) {
        return capitalize(word).equals(word) || word.toLowerCase().equals(word) || word.toUpperCase().equals(word);
    }
    
    public String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}