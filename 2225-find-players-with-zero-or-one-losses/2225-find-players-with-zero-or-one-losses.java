class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lossMap = new HashMap<>();
        for(int[] match : matches) {
            lossMap.put(match[0], lossMap.getOrDefault(match[0], 0));
            lossMap.put(match[1], lossMap.getOrDefault(match[1], 0) + 1);
        }
        List<Integer> winner = new ArrayList<>();
        List<Integer> loser = new ArrayList<>();
        for(int key : lossMap.keySet()) {
            if(lossMap.get(key) == 0) {
                winner.add(key);
            } 
            if(lossMap.get(key) == 1) {
                loser.add(key);
            }
        }
        Collections.sort(winner);
        Collections.sort(loser);
        return Arrays.asList(winner, loser);
    }
}