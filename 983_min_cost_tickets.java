//https://leetcode.com/problems/minimum-cost-for-tickets/
class Solution {
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;
    
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new Integer[366];
        dayset = new HashSet();
        for (int day: days) {
            dayset.add(day);
        }
        
        return dp(1);
        
    }
    
    public int dp(int day) {
        if (day > 365)
            return 0;
        
        if (memo[day] != null)
            return memo[day];
        
        int ans;
        if (dayset.contains(day)) {
            ans = Math.min(dp(day + 1) + costs[0], dp(day + 7) + costs[1]);
            ans = Math.min(ans, dp(day + 30) + costs[2]);
        }
        else {
            ans = dp(day + 1);
        }
        
        memo[day] = ans;
        
        return ans;
        
    }
    
}