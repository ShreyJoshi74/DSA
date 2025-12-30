class Solution {
    public String resultingString(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (stack.isEmpty()) {
                stack.push(c);
            }
            else if ((c - stack.peek() + 26) % 26 == 1 || (c - stack.peek() + 26) % 26 == 25) {
                stack.pop();
            }
                else {
                    stack.push(c);
                }
            }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}