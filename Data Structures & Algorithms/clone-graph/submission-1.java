/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }

        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        Node clone = new Node(node.val);
        map.put(node, clone);
        q.offer(node);
        
        // while(!q.isEmpty()){
        //     Node curr = q.poll();
        //     for(Node ne:curr.neighbors){
        //         if(!map.containsKey(ne)){
        //             map.put(ne,new Node(ne.val));
        //             q.offer(ne);
        //         }
        //         map.get(curr).neighbors.add(map.get(ne));
        //     }
        // }
        dfs(node,map);

        return map.get(node);
    }

    public void dfs(Node node,Map<Node,Node> map){

        for(Node ne:node.neighbors){
            if(!map.containsKey(ne)){
                map.put(ne, new Node(ne.val));
                dfs(ne,map);
            }
            map.get(node).neighbors.add(map.get(ne));
        }
    }


}