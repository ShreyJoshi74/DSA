class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int mod = 100000;
        int n = arr.length;
        int[] dist = new int[100000];
        Arrays.fill(dist,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()){
            int top = q.poll();
            if(top == end){
                return dist[top];
            }
            for(int i = 0; i < n; i++){
                int pushed = (top * arr[i]) % 100000;
                if(dist[pushed] == -1 ){
                    dist[pushed] = dist[top] + 1;
                    q.add(pushed);
                }
            }
        }
        return -1;
    }
}
