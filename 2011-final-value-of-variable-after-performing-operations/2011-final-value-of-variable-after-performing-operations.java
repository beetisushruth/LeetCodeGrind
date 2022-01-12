class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int change = 0;
        for(String s : operations) {
            if(s.contains("+")) change++;
            else change--;
        }
        return change;
    }
}