class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<Integer> []adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();   
        }
        for(int []edge: edges){
            adj[edge[0]].add(edge[1]);  
            adj[edge[1]].add(edge[0]);
        }
        int []visited = new int[n];

        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                count++;
                dfs(adj,i,visited);
            }
        }

        return count;
    }

    public void dfs(ArrayList<Integer> []adj, int node, int[]visited){
        visited[node]=1;
        for(int i:adj[node]){
            if(visited[i]==0){
               dfs(adj,i,visited); 
            }
        }

    }
}
