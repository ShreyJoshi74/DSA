class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < directions.length(); i++){
            char current = directions.charAt(i);
            while(!stack.isEmpty()){
                if(current == 'S' && stack.peek() == 'R'){
                    stack.pop();
                    count++;
                }else if(current == 'L' && stack.peek() == 'R'){
                    count += 2;
                    stack.pop();
                    current = 'S';
                }else if(current == 'L' && stack.peek() == 'S'){
                    count++;
                    stack.pop();
                    current = 'S';
                }else break;
            }
            stack.push(current);
            System.out.println(current);
        }
        return count;
    }
}