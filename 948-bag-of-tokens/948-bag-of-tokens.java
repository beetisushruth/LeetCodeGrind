class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        Arrays.sort(tokens);
        while(left <= right) {
            if(power >= tokens[left]) {
                score++;
                power -= tokens[left];
                left++;
            } else if(score > 0) {
                power += tokens[right];
                score--;
                right--;
            } else {
                left++;
            }
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
    
}