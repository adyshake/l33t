//https://leetcode.com/problems/pascals-triangle/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (numRows == 0) {
            return res;    
        }
        
        int curRow = 1;
        
        if (numRows >= 1) {
            res.add(new ArrayList<>(Arrays.asList(1)));
            ++curRow;
        }
        if (numRows >= 2){
            res.add(new ArrayList<>(Arrays.asList(1, 1)));
            ++curRow;
        }
        
        while (curRow <= numRows) {
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);

            int firstNum = 0;
            int secondNum = 1;
            for (int i = 1; i < curRow - 1; ++i) {
                List<Integer> prevRow = res.get(curRow - 1 - 1);
                int newNum = prevRow.get(firstNum) + prevRow.get(secondNum);
                newRow.add(newNum);
                ++firstNum;
                ++secondNum;
            }

            newRow.add(1);
            res.add(newRow);
            ++curRow;
        }
        
        return res;
    }
}