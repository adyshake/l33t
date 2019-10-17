//https://leetcode.com/problems/number-of-islands/
class Solution {
    public boolean isSafe(int i, int j, char[][] grid, boolean[][] visited) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return false;
        }
        if (grid[i][j] == '1' && visited[i][j] == false)
            return true;
        else
            return false;
    }
    
    int poss[][] = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    
    public void DFS(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;
        for (int [] neighbour: poss) {
             if ( isSafe(i + neighbour[0] , j + neighbour[1], grid, visited) ) {
                DFS(i + neighbour[0] , j + neighbour[1], grid, visited);
             } 
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    System.out.println("NEW DFS");
                    DFS(i, j, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }
}