//https://leetcode.com/problems/median-of-two-sorted-arrays/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedLength = nums1.length + nums2.length;
        int [] merged = new int[mergedLength];
        int i = 0, j = 0, z = 0;
        
        
        while( i < nums1.length && j < nums2.length ) {
            if (z > mergedLength/2) {
                break;
            }
            
            if (nums1[i] <= nums2[j]) {
                merged[z++] = nums1[i++];
            }
            else {
                merged[z++] = nums2[j++];
            }
        }
        
        while ( i < nums1.length) {
            if ( z > mergedLength/2) {
                break;
            }
            merged[z++] = nums1[i++];
        }
        
        while (j < nums2.length) {
            if (z > mergedLength/2) {
                break;
            }
            
            merged[z++] = nums2[j++];
        }
        
        if (mergedLength % 2 == 0 ) {
            return ((merged[z-1] + merged[z-2])/2.0);
        }
        else {
            return merged[z-1];
        }
    }
}