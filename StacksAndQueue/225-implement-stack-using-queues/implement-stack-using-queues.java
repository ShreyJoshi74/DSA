class MyStack {
    Queue<Integer> q;

    public MyStack() {
          q = new LinkedList<>();
    }
    
    public void push(int num) {
        q.add(num);
    }
    
    public int pop() {
        if (q.isEmpty()) {
            return -1;
        } else {
            List<Integer> ls = new ArrayList<>(q);
            Collections.reverse(ls);
            int output = ls.remove(0);
            q.clear();
            Collections.reverse(ls);
            q.addAll(ls);
            return output;
        }
    }
    
    public int top() {
        if (q.isEmpty()) {
            return -1;
        } else {
            List<Integer> ls = new ArrayList<>(q);
            Collections.reverse(ls);
            return ls.get(0);
        }
    }
    
    public boolean empty() {
        if(q.isEmpty()) return true;
        else return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */