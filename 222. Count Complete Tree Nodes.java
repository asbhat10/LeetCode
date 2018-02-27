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
    int count = 0;
    public int countNodes(TreeNode root) {
        if(root ==null)
            return 0;

        int height = 0;
        TreeNode l  = root;
        TreeNode r = root;

        while(r != null){
            l = l.left;
            r = r.right;
            height++;
        }

        if(l==null)
            return (1<<height) -1;
        return countNodes(root.left)+countNodes(root.right)+1;

    }

}
