class Solution {
    public int[] plusOne(int[] digits) {
        
        
        int carry = 1;

        for(int i = digits.length - 1; i >= 0; i--){
            int number = digits[i] + carry;
            if(number == 10){
                digits[i] = 0;
                carry = 1;
            }
            else{
                digits[i] = number;
                carry = 0;
                break;
            }
        }
        if(carry == 1){
            int[] output = new int[digits.length + 1];
            output[0] = 1;
            return output;
        }
        return digits;
    }
}