//https://leetcode.com/problems/repeated-substring-pattern/
class Solution {
    public int[] computePrefix(String p) {
        int len = p.length();
        int[] prefix = new int[len];
        Arrays.fill(prefix, 0);
        for (int i = 1; i < len; i++){
            int j = prefix[i-1];
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = prefix[j-1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j = j + 1;
            }
            prefix[i] = j;
        }
        return prefix;
    }
    public boolean repeatedSubstringPattern(String s) {
        int [] prefix = computePrefix(s);
        //System.out.println(Arrays.toString(prefix));
        
        int len = s.length();
        int last = prefix[len - 1];
        int sizeOfPattern = len - last;
        
        
        if (last == 0)
            return false;
        
        if (last % sizeOfPattern > 0)
            return false;
        
        return true;
    }
}