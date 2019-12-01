//https://leetcode.com/problems/string-to-integer-atoi/description/

class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        
        if (len == 0) {
            return 0;
        }
        
        int i = 0;
        
        while (i < len) {
            if (str.charAt(i) != ' ') {
                break;
            }
            ++i;
        }
        
        if (i == len)
            return 0;
        
        int sign = 1;
        
        if (str.charAt(i) == '-') {
            sign = -1;
            ++i;
        }
        else if (str.charAt(i) == '+') {
            sign = 1;
            ++i;
        }
        
        
        Stack<Integer> s = new Stack<>();
        
        while (i < len) {
            String cur = Character.toString(str.charAt(i));
            if (!cur.matches("[0-9]")) {
                break;
            }
            
            int curInt = Integer.parseInt(cur);
            //System.out.println("curInt" + curInt);
            s.push(curInt);
            
            ++i;
        }
        
        
        int pow = 0;
        long res = 0;
        while (!s.empty()) {
            int cur = s.pop();
            //System.out.println(cur);
            res += cur * Math.pow(10, pow);
            ++pow;
        }
        
        res = res * sign;
        
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else if (res <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        
        return (int)res;
    }
}