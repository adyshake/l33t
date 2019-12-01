//https://leetcode.com/problems/binary-tree-right-side-view/
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
    public List<Integer> rightSideView(TreeNode root) {
        return helper(root);
    }
    
    List<Integer> helper(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        if (root == null) {
            return list;
        }
        
        List<TreeNode> a1 = new ArrayList<>();
        a1.add(root);
        List<TreeNode> a2 = new ArrayList<>();
        

        
        while(!a1.isEmpty()) {
            int lastElement = a1.size() - 1;
            if (lastElement >= 0) {
                int addToList = a1.get(lastElement).val;
                list.add(addToList);
            }

            
            a2.clear();
            for (TreeNode cur: a1) {
                if (cur.left != null) {
                    a2.add(cur.left);
                }
                if (cur.right != null) {
                    a2.add(cur.right);
                }
            }
            
            lastElement = a2.size() - 1;
            if (lastElement >= 0) {
                int addToList = a2.get(lastElement).val;
                list.add(addToList);                
            }

            
            a1.clear();
            for (TreeNode cur: a2) {
                if (cur.left != null) {
                    a1.add(cur.left);
                }
                if (cur.right != null) {
                    a1.add(cur.right);
                }
            }

        }

        return list;
    }
}