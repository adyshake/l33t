//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int max = 0;
        int cmax = 0;
        int start =0;
        int end = 0;
        std::map<char, int> M;
        //abcbc
        for (end = 0; end < s.size(); end++)
        {
            if (M.find(s[end]) != M.end())
            {
                //found
                start = std::max(M[s[end]] + 1, start);
            }
            M[s[end]] = end;
            cmax = end - start + 1;
            
            max = std::max(cmax, max);
            
        }
        
        return max;
    }
};