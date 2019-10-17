//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int low = 0;
        int high = nums.length - 1;
        
        int first = -1;
        int last =  -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] == target && ( (mid == 0) ||  (nums[mid - 1] < nums[mid]) ) )  {
                first = mid;
                break;
            }
            else if ((nums[mid] == target && nums[mid - 1] == nums[mid]) || (nums[mid] > target)) {
                //search left
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                //search right
                low = mid + 1;
            }

        }
        
         low = 0;
         high = nums.length - 1;
         while (low <= high) {
            int mid = (low + high) / 2;
            
            if (nums[mid] == target && ( (mid == nums.length - 1) || (nums[mid + 1] > nums[mid] ) ) )  {
                last = mid;
                break;
            }
            else if ((nums[mid] == target && nums[mid + 1] == nums[mid]) || (nums[mid] < target)) {
                //search right
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                //search left
                high = mid - 1;
            }

        }
        
        int [] res = {first, last};
        return res;
        
    }
}