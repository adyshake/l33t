//https://leetcode.com/problems/jump-game/submissions/
class Solution {
    int target;
    int[] nums;
    Boolean[] vis;
    
    public boolean canJump(int[] nums) {
        this.target = nums.length - 1;
        this.nums = nums;
        vis = new Boolean[nums.length];
        Arrays.fill(vis, null);
        
        return helper(0);
    }
    
    public boolean helper(int start) {        
        if (vis[start] != null)
            return vis[start];
        
        if (start + nums[start] >= target) {
            vis[start] = true;
            return true;
        }
        
        if (nums[start] == 0) {
            vis[start] = false;
            return false;
        }
        
        int jumps = nums[start];
        while (jumps >= 1) {
            int i = start + jumps;
            if (helper(i) == true) {
                vis[i] = true;
                return true;
            }
            jumps--;
        }
        
        vis[start] = false;
        return false;
        
    }
}