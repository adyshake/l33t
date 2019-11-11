//https://leetcode.com/problems/letter-case-permutation/
class Solution {
    public List<String> letterCasePermutation(String S) {   
        List<String> res = new ArrayList<String>();
        int len = S.length();
        
        helper(S, res, "");
        
        return res;
    }
    
    void helper(String S, List<String> res, String cur) {
        if (cur.length() == S.length()) {
            res.add(cur);
            return;
        }
        
        String curChar = Character.toString(S.charAt(cur.length()));
        if (curChar.matches("[a-zA-Z]")) {    
            helper(S, res, cur + curChar.toLowerCase());
            helper(S, res, cur + curChar.toUpperCase());
            
        }
        else {
            helper(S, res, cur + curChar);
        }
    }
}