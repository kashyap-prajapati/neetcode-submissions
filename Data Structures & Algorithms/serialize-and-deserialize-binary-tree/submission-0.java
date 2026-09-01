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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        build(root, str);
        return str.toString();
    }   

    private void build(TreeNode root, StringBuilder builder){
        if(root==null){ 
            builder.append("#,");
            return;
        }
        builder.append(root.val).append(",");
        build(root.left, builder);
        build(root.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return parse(new ArrayDeque<>(Arrays.asList(data.split(","))));
    }

    private TreeNode parse(Deque<String> q){
        String s = q.poll();
        if(s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left=parse(q);
        root.right=parse(q);
        return root;
    }
}
