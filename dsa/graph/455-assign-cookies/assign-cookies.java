class Solution {
    public int findContentChildren(int[] g, int[] s) {
        PriorityQueue<Integer> children = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        PriorityQueue<Integer> size = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int p : g){
            children.add(p);
        }
        for(int d : s){
            size.add(d);
        }
        int count = 0;
        while(!children.isEmpty() && !size.isEmpty()){
            int greed = children.peek();
            int cookie = size.peek();
            if(cookie >= greed){
                children.poll();
                size.poll();
                count++;
            }else{
                children.poll();
            }
        }
        return count;
    }
}