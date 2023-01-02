class Solution {
    public boolean detectCapitalUse(String word) {
        int first = word.charAt(0) - 'a';
        boolean smallDetect = first >= 0 && first <= 25 ? true : false;
        int capCount = !(first >= 0 && first <= 25) ? 1 : 0;
        for(int i=1; i<word.length(); i++) {
            int curr = word.charAt(i) - 'a';
            if(curr >= 0 && curr <= 25) smallDetect = true;
            if(smallDetect && !(curr >= 0 && curr <= 25)) return false;
            if(!(curr >= 0 && curr <= 25)) capCount++;
            if(capCount > 1 && smallDetect) return false;
        }
        return true;
    }
}