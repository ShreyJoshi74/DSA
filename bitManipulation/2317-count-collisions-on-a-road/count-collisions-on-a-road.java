class Solution {
    public int countCollisions(String directions) {
        int count = 0;
        int i = 0;
        int k = directions.length();
        while(i < k && directions.charAt(i) == 'L') i++;
        int j = directions.length() -1;
        while(j >= 0 && directions.charAt(j) == 'R') j--;
        for(;i <= j; i++){
            if(directions.charAt(i) != 'S') count++;
        }
        return count;
    }
}