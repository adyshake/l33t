//https://leetcode.com/problems/unique-binary-search-trees/
class Solution {
    
    int[][]dp;
    
    public int numTrees(int n) {
        this.dp = new int[n+1][n+1];
        //[1, 2, 3, 4, 5]
        return helper(1, n);
    }
    
    int helper(int left, int right) {
        // System.out.println("Left: "  + left + " Right: " + right);
          
        if (left == right || left > right) {
            return 1;
        }     
        
        if (dp[left][right] != 0)
            return dp[left][right];
   
        
        int sum = 0;
        //Pick each element as root
        for(int i = left; i <= right; i++) {
            // System.out.println("Picking root as: " + i);
            //pick left subtree and pick right subtree
            sum += helper(left, i - 1) * helper(i + 1, right);
        }
        
        dp[left][right] = sum;
        // System.out.println("Sum: " + sum);
        return sum;
    }
}