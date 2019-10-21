//https://leetcode.com/problems/binary-tree-inorder-traversal/
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (root == null)
            return res;
        
        return travHelper(res, root);
    }
    
    public List<Integer> travHelper(List<Integer> res, TreeNode root) {
        if (root.left != null)
            travHelper(res, root.left);
        res.add(root.val);
        if (root.right != null)
            travHelper(res, root.right);
        
        return res;
    }
    
}