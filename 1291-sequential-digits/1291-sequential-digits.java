class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i=1; i<10; i++) curr.add(i);
        int j = 0;
        while(j < curr.size() && getNextNumber(curr.get(j)) <= high) {
            List<Integer> temp = new ArrayList<>();
            while(j < curr.size() && getNextNumber(curr.get(j)) != 0 && getNextNumber(curr.get(j)) <= high)             {
                temp.add(getNextNumber(curr.get(j)));
                if(getNextNumber(curr.get(j)) >= low) ans.add(getNextNumber(curr.get(j)));
                j++;
            }
            curr = temp;
            j = 0;
        }
        return ans;
    }
    // 12 23 34 45 56 67 78 89 123 234 345 567 678 789 
    
    public int getNextNumber(int i) {
        if(i%10 == 9) return 0;
        return i*10 + (i%10 + 1);
    }
}