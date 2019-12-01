//https://leetcode.com/problems/minimum-time-visiting-all-points/
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 0 || points.length == 1)
            return 0;
        
        int numPoints = points.length;
        
        int res = 0;
        
        for (int i = 0; i < numPoints - 1; i++){
            int[] p1  = points[i];
            int[] p2 = points[i+1];
            
            int absX = Math.abs(p1[0] - p2[0]);
            int absY = Math.abs(p1[1] - p2[1]);
            
            int max = Math.max(absX, absY);
            
            res += max;
        }
        
        return res;
    }
}