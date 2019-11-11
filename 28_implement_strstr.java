//https://leetcode.com/problems/implement-strstr/
class Solution {
    public int strStr(String haystack, String needle) {
        
        int hLength = haystack.length();
        int nLength = needle.length();
        
        if (haystack.equals(needle))
            return 0;
        
        for (int i = 0; i < hLength - nLength + 1; i++) {
            // System.out.println(i);
            int tempI = i;
            int j = 0;
            while (j < nLength) {
                if (haystack.charAt(tempI) == needle.charAt(j)) {
                    tempI++;
                    j++;
                }
                else {
                    break;
                }
            }
            
            // System.out.println(j);
            
            if (j == nLength) {
                return i;
            }
            
        }
        
        return -1;
    }
}