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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return List.of();
        }
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root,0));
        List<List<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()){
            Pair<TreeNode,Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int level = p.getValue();

            if(level>=list.size()){
                list.add(new ArrayList<>());
                list.get(level).add(node.val);
            }else{
                 list.get(level).add(node.val);
            }
            if(node.left!=null){
                queue.add(new Pair<>(node.left,level+1));
            }
            if(node.right!=null){
                queue.add(new Pair<>(node.right,level+1));
            }
        }  
        return list;
    }
}
