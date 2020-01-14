//https://leetcode.com/problems/battleships-in-a-board/

class Solution {
    int [][] visited;
    int cols;
    int rows;
    char [][] board;
    
    public int countBattleships(char[][] board) {
        this.rows = board.length;
        this.cols = board[0].length;
        
        this.board = board;
        
        this.visited = new int[rows][cols];
        
        int numShips = 0;
        
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'X' && visited[i][j] == 0) {
                    helper(i, j);
                    numShips++;
                }
            }
        }
        return numShips;
    }
    
    public void helper(int row, int col) {
        //Check Right
        if (col + 1 < cols && board[row][col + 1] == 'X' && visited[row][col + 1] == 0) {
            visited[row][col + 1] = 1;
            helper(row, col + 1);
            return;
        }
        
        //Check Bottom
        if (row + 1 < rows && board[row + 1][col] == 'X' && visited[row + 1][col] == 0) {
            visited[row + 1][col] = 1;  
            helper(row + 1, col);
            return;
        }
        
        return;
    }
}