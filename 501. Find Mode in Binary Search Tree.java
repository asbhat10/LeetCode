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
    int max = 1;
    Integer prev = null;
    int count = 1;
    List<Integer> list = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);
        return res;
    }
    
    private void inOrder(TreeNode node){
        if(node == null)
            return;
        inOrder(node.left);
        if(prev != null){
            if(prev == node.val){
                count++;
            }else{
                count=1;
            }
            
        }
        if(count == max)
            list.add(node.val);
        else if(count > max){
            list.clear();
            list.add(node.val);
            max = count;
        }
        prev = node.val;
        inOrder(node.right);
        
    }
}