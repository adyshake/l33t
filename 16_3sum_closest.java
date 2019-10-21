//https://leetcode.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        //-4, -1, 1, 2 
        
        int gmax = Integer.MAX_VALUE;
        int closestSum = 0;
        
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                int diff = Math.abs(sum - target);
                
                if (gmax > diff) {
                    gmax = diff;
                    closestSum = sum;
                }

                if (sum > target) {
                    k--;
                }
                else {
                    j++;
                }                
            }
        }
        return closestSum;
    }
}