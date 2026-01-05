class Solution {
    // agar negative even me hey to chill hey hojayega
    // agar negative integer odd me hoge to bas ek sabse chota koi bhi integer return krna hey(positive negative kuch bhi chalega)
    public long maxMatrixSum(int[][] matrix) {
        int negative = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                
                if(matrix[i][j] < 0){
                    negative++;
                    sum = sum + -1 * matrix[i][j];
                }else
                    sum = sum + matrix[i][j];
                min = Math.min(min,Math.abs(matrix[i][j] - 0));
            }
        }

        return (negative % 2 == 0) ? sum : sum - 2 * min;
    }
}