//https://leetcode.com/problems/interleaving-string/
class Solution {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int [][] memo = new int[s1.length() + 1][s2.length() + 1];
        return isInterleaveHelper(s1, s2, s3, memo);
    }
    
    public boolean isInterleaveHelper(String s1, String s2, String s3, int [][] memo) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        
        if ( memo[n][m] != 0 ) {
            return (memo[n][m] == 1) ? true: false;
        }
        
        boolean pathA = false, pathB = false;
        
        if (n == 0) {
            if (s2.equals(s3) == false) {
                memo[n][m] = -1;
                return false;
            } else {
                memo[n][m] = 1;
                return true;
            }
        }
            
        if (m == 0) {
            if (s1.equals(s3) == false) {
                memo[n][m] = -1;
                return false;
            } else {
                memo[n][m] = 1;
                return true;
            }
        }
        
        if (s3.charAt(k - 1) != s1.charAt(n - 1) && s3.charAt(k - 1) != s2.charAt(m - 1)) {
            memo[n][m] = -1;
            return false;
        }
        
        if (s3.charAt(k - 1) == s1.charAt(n - 1)) {
            pathA = isInterleaveHelper(s1.substring(0, n - 1), s2.substring(0, m), s3.substring(0, k - 1), memo);
        }
        if (s3.charAt(k - 1) == s2.charAt(m - 1)) {
             pathB = isInterleaveHelper(s1.substring(0, n), s2.substring(0, m - 1), s3.substring(0, k - 1), memo);
        }

        if ((pathA || pathB) == false) {
            memo[n][m] = -1;
            return false;
        }
        else {
            memo[n][m] = 1;
            return true;
        }
    }
}