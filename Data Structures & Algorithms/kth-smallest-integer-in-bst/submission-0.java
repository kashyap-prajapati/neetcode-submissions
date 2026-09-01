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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // Visit node
                k--;
                if (k == 0) return curr.val;
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    // Create thread
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // Restore thread
                    prev.right = null;
                    // Visit node
                    k--;
                    if (k == 0) return curr.val;
                    curr = curr.right;
                }
            }
        }

        return -1; // should not reach here if k is valid
    }
}
