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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int  i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0, preorder.length-1,inorder, 0, inorder.length-1, map);
    }

    public TreeNode buildTree(int []preorder, int pre_start, int pre_end,
                             int []inorder, int in_start, int in_end, Map<Integer, Integer> map){
        
        if(pre_start > pre_end || in_start > in_end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_start]);
       
        int in_root = map.get(root.val);
        int nums_left = in_root - in_start;

        root.left = buildTree(preorder, pre_start+1, pre_start+nums_left,
                            inorder, in_start, in_root-1, map);
        
        root.right = buildTree(preorder, pre_start+nums_left+1, pre_end,
                            inorder, in_root+1, in_end, map);

        return root;
    }
}
