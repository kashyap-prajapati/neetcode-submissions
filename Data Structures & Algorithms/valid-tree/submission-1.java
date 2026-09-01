class Solution {
    public boolean validTree(int n, int[][] edges) {
        ArrayList<Integer> []adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();   
        }
        for(int []edge: edges){
            adj[edge[0]].add(edge[1]);  
            adj[edge[1]].add(edge[0]);
        }
        int []visited = new int[n];
        if (dfs(adj, 0, -1, visited)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<Integer> []adj, int node, int parent, int[]visited){
        
        visited[node]=1;
        for(int i:adj[node]){
            if(visited[i]==0){
                if(dfs(adj,i, node,visited)){
                    return true;
                } 
            }else if(i!=parent){
                return true;
            }
        }
        return false;
    }
}
