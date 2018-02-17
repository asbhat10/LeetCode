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
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root,list);
        for(int i=1;i<list.size();i++){
            min = Math.min(min, list.get(i)- list.get(i-1));
        }
        return min;
    }
    
    private void inOrder(TreeNode root,List<Integer> list){
        if(root == null) return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
        // if(root.left !=null){
        //     int left = inOrder(root.left);
        //     System.out.println(root.val+"    "+left+"     "+Math.abs(root.val-left));
        //     min = Math.min(min,Math.abs(root.val-left));
        // }
        // if(root.right !=null){
        //     int right = inOrder(root.right);
        //     System.out.println(root.val+"    "+right+"     "+Math.abs(root.val-right));
        //     min = Math.min(min,Math.abs(root.val-right));
        // }
        // return root.val;
    }
}