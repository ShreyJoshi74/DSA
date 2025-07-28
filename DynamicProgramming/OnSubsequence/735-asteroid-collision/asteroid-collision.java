class Solution {
    public int mod(int n){
        if(n < 0) return -1 * n;
        else return n;
    }
    public boolean ifCollision(int a,int b){
        if(a<0 && b > 0) return true;
        return false;
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        if(asteroids.length <= 1) return asteroids;
        st.add(0);
        for(int i = 1; i < asteroids.length;i++){
            if(!st.isEmpty() && !ifCollision(asteroids[i],asteroids[st.peek()])) st.add(i);
            else {
                boolean indicator = false;
                while(!st.isEmpty()&& ifCollision(asteroids[i],asteroids[st.peek()]) && mod(asteroids[i]) >= mod(asteroids[st.peek()])){
                    if(mod(asteroids[i]) == mod(asteroids[st.peek()])) {
                        st.pop();
                        indicator = true;
                        break;
                    }
                    st.pop();
                }
                if((st.isEmpty()&& !indicator) || (!indicator &&!st.isEmpty() && !ifCollision(asteroids[i],asteroids[st.peek()])) ) st.add(i);
                
            }
        }
        int a = st.size();
        int[] output = new int[a];
        for(int i = a-1; i>=0; i--){
            output[i] = asteroids[st.pop()];
        }
        return output;
    }
}