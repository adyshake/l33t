//https://leetcode.com/problems/validate-binary-search-tree/
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
    public boolean isValidBST(TreeNode root) {
        
        if (root == null)
            return true;
        
        return isValidHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }
    
    public boolean isValidHelper(TreeNode head, long min, long max) {
        
        if (head == null) {
            return true;
        }
        
        if (head.val >= max || head.val <= min)
            return false;
        
        return isValidHelper(head.left, min, head.val) && isValidHelper(head.right, head.val, max);
        
    }
}