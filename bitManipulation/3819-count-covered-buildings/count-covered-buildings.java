class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int maxX = 0;
        int maxY = 0;
        for(int[] building : buildings){
            maxX = Integer.max(building[0],maxX);
            maxY = Integer.max(building[1],maxY);
        }
        int[] leftColumn = new int[maxX + 1];
        int[] rightColumn = new int[maxX + 1];
        int[] upperRow = new int[maxY + 1];
        int[] bottomRow = new int[maxY + 1];

        Arrays.fill(leftColumn,Integer.MAX_VALUE);
        Arrays.fill(rightColumn,Integer.MAX_VALUE);
        Arrays.fill(upperRow,Integer.MAX_VALUE);
        Arrays.fill(bottomRow,Integer.MAX_VALUE);

        int i , j;
        for(int[] building : buildings){
            i = building[0];
            j = building[1];
            leftColumn[i] = Math.min(leftColumn[i],j);
            rightColumn[i] = Math.min(rightColumn[i],(maxY-1) - j);
            upperRow[j] = Math.min(upperRow[j],i);
            bottomRow[j] = Math.min(bottomRow[j],(maxX-1)-i);


        }
        int count = 0;

        for(int[] building : buildings){
            i = building[0];
            j = building[1];
            if(
                leftColumn[i] != Integer.MAX_VALUE &&
                rightColumn[i] != Integer.MAX_VALUE &&
                upperRow[j] != Integer.MAX_VALUE &&
                bottomRow[j] !=  Integer.MAX_VALUE &&
                leftColumn[i] < j  &&
                j < (maxY - 1) - rightColumn[i] &&
                upperRow[j] < i  &&
                i <  (maxX - 1) - bottomRow[j]
            ){
                count += 1;
            }
        }

        return count;
    }
}