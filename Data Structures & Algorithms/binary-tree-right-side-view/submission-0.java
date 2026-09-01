/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        rightSide(root,0,temp);
        return temp;
    }

    public void rightSide(TreeNode root, int level,List<Integer> temp){
        if(root==null)
            return;

        if(temp.size()<level+1){
            temp.add(root.val);
        }
        rightSide(root.right, level+1, temp);
        rightSide(root.left, level+1, temp);
    }
}
