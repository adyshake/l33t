class Solution {
    char[][] grid;
    int numRows;
    int numCols;
    
    
    public void dfs(int i, int j) {
        grid[i][j] = 0;
        
        if (i + 1 < numRows && grid[i+1][j] == '1') dfs(i + 1, j);
        if (j + 1 < numCols && grid[i][j + 1] == '1') dfs(i, j + 1);
        if (i - 1 >= 0 && grid[i - 1][j] == '1') dfs(i - 1, j);
        if (j - 1 >= 0 && grid[i][j - 1] == '1') dfs(i, j - 1);
    }
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.numRows = grid.length;
        
        if (numRows == 0)
            return 0;
        
        this.numCols = grid[0].length;
        
        int numIslands = 0;
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(i, j);
                }
            }
        }
        
        return numIslands;
    }
}