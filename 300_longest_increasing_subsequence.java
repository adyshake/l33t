//https://leetcode.com/problems/longest-increasing-subsequence/
class Solution {
    int[] nums;
    int[][] memo;
    
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        
        this.memo = new int[nums.length + 1][nums.length];
        
        // for (int[] mem: memo) {
        //     Arrays.fill(mem, Integer.MIN_VALUE);
        // }
        
        return helper(-1, 0);
    }
    
    public int helper(int prev, int cur) {        
        if (cur == nums.length) {
            return 0;
        }
        
        if (memo[prev + 1][cur] > 0)  {
            return memo[prev + 1][cur];
        }
        
        int taken = 0;
        if (prev < 0 || nums[prev] < nums[cur]) {
            taken = 1 + helper(cur, cur + 1);
        }
        
        int nottaken = helper(prev, cur + 1);
        
        memo[prev + 1][cur] = Math.max(taken, nottaken);
        
        return memo[prev + 1][cur];
    }
}