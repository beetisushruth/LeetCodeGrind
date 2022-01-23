class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i=1; i<10; i++) curr.add(i);
        int j = 0;
        while(j < curr.size() && getNextNumber(curr.get(j)) <= high) {
            List<Integer> temp = new ArrayList<>();
            while(j < curr.size() && getNextNumber(curr.get(j)) != 0 && getNextNumber(curr.get(j)) <= high)             {
                int nextNumber = getNextNumber(curr.get(j));
                temp.add(nextNumber);
                if(nextNumber >= low) ans.add(nextNumber);
                j++;
            }
            curr = temp;
            j = 0;
        }
        return ans;
    }
    
    public int getNextNumber(int i) {
        if(i%10 == 9) return 0;
        return i*10 + (i%10 + 1);
    }
}