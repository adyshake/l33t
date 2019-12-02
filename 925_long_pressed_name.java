//https://leetcode.com/problems/long-pressed-name/
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        for (int i = 0, j = 0; i < name.length(); ++i) {
            char cur = name.charAt(i);
            char cur_typ = typed.charAt(j);
            
            //System.out.println("First check " + cur + " " + cur_typ);
            
            if (cur != cur_typ) {
                return false;
            }
            
            int num_pressed = 1;
            while (i + 1 < name.length() && name.charAt(i) == name.charAt(i+1)) {
                ++i;
                ++num_pressed;
            }
            
            int num_occurred = 0;
            while (cur_typ == cur) {
                //System.out.println(cur + " " + cur_typ);
                ++j;
                ++num_occurred;
                
                if (j >= typed.length()) {
                    j--;
                    break;
                }
                
                cur_typ = typed.charAt(j);
            }
            
            if (num_occurred < num_pressed) {
                //System.out.println(num_occurred + " " + num_pressed);
                return false;
            }
        }
        
        return true;
    }
}