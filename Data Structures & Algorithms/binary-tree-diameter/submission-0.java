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
    public int diameterOfBinaryTree(TreeNode root) {
       int []maxi = new int[1];
        diameter(root, maxi);
        return maxi[0];
    }

    public int diameter(TreeNode root, int[] maxi){
        if(root==null)
            return 0;
        
        int left  = diameter(root.left,maxi);
        int right  = diameter(root.right,maxi);
        maxi[0] = Math.max(left+right,maxi[0]);
        return 1+Math.max(left,right);
    }
}
