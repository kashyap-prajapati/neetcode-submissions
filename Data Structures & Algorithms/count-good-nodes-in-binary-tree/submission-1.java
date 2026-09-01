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
    public int goodNodes(TreeNode root) {
        return good(root, root.val);
    }

    public int good(TreeNode root, int target){
        if(root==null) return 0;
        int left = good(root.left, Math.max(target, root.val));
        int right = good(root.right, Math.max(target, root.val));
        return left + right + (root.val>=target ? 1:0);
    }
}
