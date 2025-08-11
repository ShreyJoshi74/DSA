class StockSpanner {
    Stack<int[]> stack ;
    int cnt;
    public StockSpanner() {
        stack = new Stack<>();
        cnt = 0;
    }
    
    public int next(int price) {
    cnt++;
    
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
        stack.pop();
    }

    int output;
    if (stack.isEmpty()) {
        output = cnt; // all days so far
    } else {
        output = cnt - stack.peek()[1];
    }

    stack.push(new int[] {price, cnt});
    return output;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */