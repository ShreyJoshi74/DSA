class Solution {
    public int minDeletionSize(String[] str) {
        int n = str[0].length();

        int m = str.length;

        boolean[] sorted = new boolean[m-1];

        int deletion = 0;

        for(int column = 0; column < n; column++){
            int count = 0;
            boolean needDeletion = false;

            for(int row = 0; row < m - 1; row++){
                if(!sorted[row] && str[row].charAt(column) > str[row + 1].charAt(column)){
                    needDeletion = true;
                    break;
                }
            }

            if(needDeletion){
                deletion++;
                continue;
            }

            for(int row = 0; row < m-1; row++){
                if(!sorted[row] && str[row].charAt(column) < str[row + 1].charAt(column)){
                    sorted[row] = true;
                }
            }
        } 
        return deletion;
    }
}