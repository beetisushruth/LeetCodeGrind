class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<asteroids.length; i++) {
            while(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0 && st.peek() < -asteroids[i]) {
                st.pop();
            }
            if(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0) {
                if(st.peek() > -asteroids[i]) continue;
                if(st.peek() == -asteroids[i]) {
                    st.pop();
                    continue;
                }
            } 
            else {
                st.add(asteroids[i]);
            }
        }
        int[] res = new int[st.size()];
        int i = res.length - 1;
        while(!st.isEmpty()) {
            res[i] = st.pop();
            i--;
        }
        return res;
    }
}