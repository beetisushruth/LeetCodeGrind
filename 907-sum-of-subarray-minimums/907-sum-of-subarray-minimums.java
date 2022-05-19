class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int [] prevsmaller=new int[n];
        int [] nextsmaller=new int[n];
        final int mod=1000000007;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            prevsmaller[i]=-1;
            nextsmaller[i]=n;
        }
        // finding the next smaller element
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                nextsmaller[i]=stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        // finding the previous smaller element
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[i]<arr[stack.peek()]){  // here we havent used = sign because it was failing for case [71,55,82,55]. In case of duplicate numbers we consider the first in occurence number as our answer
                stack.pop();
            }
            if(!stack.isEmpty()){
                prevsmaller[i]=stack.peek();
            }
            stack.push(i);
        }
        long res=0;
        for(int i=0;i<n;i++){
            long left= (long)i -prevsmaller[i];
            long right=nextsmaller[i]-(long)i;
            res=(res+ (arr[i]*left*right)%mod)%mod;
        }
        return (int) res;
    }
}