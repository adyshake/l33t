//https://leetcode.com/problems/zigzag-conversion/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        HashMap<Integer, StringBuffer> map = new HashMap<>();
        int i = 0;
        int row = 0;        
        boolean forward = true;
        while (i < s.length()) {
            if (row > numRows - 1) {
                forward = false;
                row -= 2;
            } else if (row < 0){
                forward = true;
                row += 2;
            }
            
            StringBuffer sb = map.get(row);

            if (sb == null) {
                sb = new StringBuffer();
            }

            sb.append(s.charAt(i));

            map.put(row, sb);
            
            if (forward) {                
                row++;
            }
            else {
                row--;
            }
            i++;
        }
        StringBuffer res = new StringBuffer();
        for (i = 0; i < numRows; i++) {
            if (map.get(i) != null)
                res.append(map.get(i));
        }
        return res.toString();
    }
}