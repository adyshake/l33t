//https://leetcode.com/problems/trapping-rain-water/
import java.util.Arrays;

class Solution {
    public int trap(int[] height) {
        
        int []lmax = new int [height.length];
        int []rmax = new int [height.length];
        
        if (height.length == 0)
            return 0;
        
        lmax[0] = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i-1] > lmax[i-1]) {
                lmax[i] = height[i-1];
            }
            else {
                lmax[i] = lmax[i-1];
            }
        }
        
        rmax[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i+1] > rmax[i+1]) {
                rmax[i] = height[i + 1];
            }
            else {
                rmax[i] = rmax[i+1];
            }
        }
        
        int water = 0;
        
        System.out.println(Arrays.toString(lmax));
        System.out.println(Arrays.toString(rmax));
        
        for (int i = 0; i < height.length; i++) {
            
            int minHeight = Math.min(lmax[i], rmax[i]);
            
            if (minHeight > height[i]) {
                water += minHeight - height[i];    
            }
            

        }
     
        return water;
    }
}