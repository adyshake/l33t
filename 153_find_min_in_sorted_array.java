//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution {
    public int findMin(int[] nums) {   
        int left = 0;
        int right = nums.length - 1;
        
        if(nums[0] <= nums[right]) {
            //Already sorted
            return nums[0];
        }
        
        while (left <= right) {
            int mid = left + (right - left)/2;
            
            if (nums[mid + 1] < nums[mid]) {
                return nums[mid+1];
            }
            
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            
            if (nums[0] < nums[mid]) {
                //search on the right side of the array
                left = mid + 1;
            }
            else if (nums[0] >= nums[mid]) {
                //search on the left side of the array
                right = mid - 1;
            }
        }
        return -1;
    }
}