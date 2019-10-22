//https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution {
    public int search(int[] nums, int target) {
        
        //Find inflection point
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        int inflec = 0;
        
        if (nums.length == 0)
            return -1;
        
        if (nums[low] <= nums[high]) {
            inflec = 0;
        }
        else {
            while (low <= high) {
                mid = (low + high)/2;

                if (nums[mid + 1] < nums[mid]) {
                    inflec = mid + 1;
                    break;
                }

                if (nums[mid - 1] > nums[mid]) {
                    //mid is the inflection
                    inflec = mid;
                    break;
                }

                if (nums[0] < nums[mid]){
                    //search right
                    low = mid + 1;
                }
                else {
                    //search left
                    high = mid - 1;
                }
            }            
        }
            
        System.out.println(inflec);
        
        int res = bsearch(nums, 0, inflec - 1, target);
        if (res == -1)
            res = bsearch(nums, inflec, nums.length - 1, target);
        
        return res;
    }
    
    public int bsearch(int [] nums, int low, int high, int target) {
        int res = -1;
        while (low <= high) {
            int mid = (low + high)/2;
            
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            
            if (nums[mid] < target) {
                //search right
                low = mid + 1;
            }
            else {
                //search left
                high = mid - 1;
            }
        }
        return res;
    }
}