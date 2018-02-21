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
    public int findSecondMinimumValue(TreeNode root) {
        if(root ==  null || root.left == null)
            return -1;
        int left = root.left.val;
        int right = root.right.val;
        
        if(root.val == root.left.val)
            left = findSecondMinimumValue(root.left);
        if(root.val == root.right.val)
            right = findSecondMinimumValue(root.right);
        
        if(left!=-1 && right != -1)
            return Math.min(left,right);
        else if(left != -1)
            return left;
        return right;
    }
}