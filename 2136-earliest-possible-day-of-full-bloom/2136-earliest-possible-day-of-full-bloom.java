class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<plantTime.length; i++) {
            list.add(i);
        }
        Collections.sort(list, (a, b) -> {
            return growTime[b] - growTime[a];
        });
        int currTime = 0;
        int plantT = 0;
        int time = 0;
        for(int i=0; i<list.size(); i++) {
            int index = list.get(i);
            plantT += plantTime[index];
            currTime = plantT + growTime[index];
            time = Math.max(time, currTime);
        }
        return time;
    }
}