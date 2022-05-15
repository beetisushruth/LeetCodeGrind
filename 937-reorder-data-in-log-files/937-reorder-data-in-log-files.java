class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            String[] aArr = a.split(" ");
            String[] bArr = b.split(" ");
            boolean isADigit = aArr[1].matches("-?\\d+(\\.\\d+)?");
            boolean isBDigit = bArr[1].matches("-?\\d+(\\.\\d+)?");
            if(isADigit != isBDigit) {
                if(!isADigit) return -1;
                else return 1;
            }
            if(!isADigit) {
                String word1 = a.substring(a.indexOf(" "));
                String word2 = b.substring(b.indexOf(" "));
                if(word1.equals(word2)) { 
                    return a.substring(0, a.indexOf(" ")).compareTo(b.substring(0, b.indexOf(" ")));
                }
                return word1.compareTo(word2);
            }
            return 0;
        });
        return logs;
    }
}