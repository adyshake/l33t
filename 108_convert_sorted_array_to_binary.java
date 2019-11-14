//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {    
        return helper(0, nums.length - 1, nums);
    }
    
    public TreeNode helper(int left, int right, int[] nums) {
        
        if (left > right || left < 0 || right >= nums.length) {
            return null;
        }
        
        int mid = left + (right - left)/2;
        
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = helper(left, mid - 1, nums);
        node.right = helper(mid + 1, right, nums);
        
        return node;
    }
}