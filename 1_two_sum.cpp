//https://leetcode.com/problems/two-sum/description/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> M;
        vector<int> result;
        for(int i = 0; i < nums.size(); i++)
        {
            int comp = target - nums[i];
            if (M.find(comp) != M.end())
            {
                //found
                result.push_back(M.find(comp)->second);
                result.push_back(i);
                break;
            }
            
            M[nums[i]] = i;
        }
        
        return result;
    }
};