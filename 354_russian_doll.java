//https://leetcode.com/problems/russian-doll-envelopes/
class Solution {
    int[][] envelopes;
    int[][] memo;
    
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        
        this.envelopes = envelopes;
        
        System.out.println(Arrays.deepToString(envelopes));
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] < e2[0]) {
                return -1;
            }
            else if (e1[0] == e2[0]) {
                if (e1[1] < e2[1]) {
                    return 1;
                }
                else if (e1[1] == e2[1]) {
                    return 0;
                }
                else {
                    return -1;
                }
            }
            else {
                return 1;
            }
            
        });
        System.out.println(Arrays.deepToString(envelopes));
        
        memo = new int[envelopes.length + 1][envelopes.length];
        
        return LIS(-1, 0);
    }
    
    public int LIS(int prev, int cur) {
        if (cur == envelopes.length) {
            return 0;
        }
        
        if (memo[prev + 1][cur] > 0) {
            return memo[prev + 1][cur];
        }
        
        int taken = 0;
        if (prev < 0 || envelopes[prev][1] < envelopes[cur][1]) {
            taken = 1 + LIS(cur, cur + 1);
        }
        int nottaken = LIS(prev, cur + 1);
        
        memo[prev + 1][cur] = Math.max(taken, nottaken);
        
        return memo[prev + 1][cur];
    }
}