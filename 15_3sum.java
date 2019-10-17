//https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        
        int i = 0;
        while(i < nums.length - 2) {
            if (i > 0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
            
                if (sum == 0) {
                    res.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                    
                    int oldk = k;
                    while (j < k && nums[oldk] == nums[k]) k--;
                }
                else {
                    if (sum > 0) {
                        //move down upper bound
                        int oldk = k;
                        while (j < k && nums[oldk] == nums[k]) k--;

                    }
                    else if (sum <= 0) {
                        //move up lower bound
                        int oldj = j;
                        while (j < k && nums[oldj] == nums[j]) j++;
                    }
                }   
            }
            i++;
        }
        
        return res;
    }
}