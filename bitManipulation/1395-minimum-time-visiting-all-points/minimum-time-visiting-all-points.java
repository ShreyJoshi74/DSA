class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if(points.length == 1) return 0;
        int time = 0;
        int prevX = points[0][0];
        int prevY = points[0][1];
        for(int[] point : points){
            int disX = Math.abs(point[0] - prevX);
            int disY = Math.abs(point[1] - prevY);

            if(disX >= disY){
                time += disY + (disX - disY);

            }
            else 
                time += disX + (disY - disX);
            prevX = point[0];
            prevY = point[1];
        }
        return time;
    }
}