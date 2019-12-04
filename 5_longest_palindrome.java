//https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        boolean[][] dp = new boolean[len][len];
        
        for (int i = len - 1; i >= 0; --i) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i+1][j-1]);
                
                //Time to update res
                if (dp[i][j] && (j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res; 
    }
}