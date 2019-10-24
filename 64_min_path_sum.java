//https://leetcode.com/problems/minimum-path-sum/
class Solution {
    public int minPathSum(int[][] grid) {        
        int memo [][] = new int [grid.length][grid[0].length];
        for (int[] r: memo)
            Arrays.fill(r, -1);
        
        return pathHelper(grid, memo, 0, 0);
    }
    
    public int pathHelper(int [][] grid, int [][] memo, int row, int col) {    
        if (row >= grid.length || col >= grid[0].length)
            return Integer.MAX_VALUE;

        if (memo[row][col] != -1)
            return memo[row][col];
        
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];
        
        int[][] n = {{0, 1},{1,0}};
        
        int ans = Math.min(
            pathHelper(grid, memo, row + n[0][0], col + n[0][1]),
            pathHelper(grid, memo, row + n[1][0], col + n[1][1])
            );
        
        memo[row][col] = ans + grid[row][col];
        return memo[row][col];
    }
}