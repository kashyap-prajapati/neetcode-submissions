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
    Map<Integer,Integer> map = new HashMap<>();
    int pre_start=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int  i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0, preorder.length-1);
    }

    public TreeNode buildTree(int []preorder, int low, int high){      
        if(low>high){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_start++]);
       
        int mid = map.get(root.val);

        root.left = buildTree(preorder, low, mid-1);
        
        root.right = buildTree(preorder, mid+1, high);

        return root;
    }
}
