class Solution {

    class DisjointSet{
        int v;
        int []parent;
        int []rank;
        public DisjointSet(int v){
            this.v=v;
            this.parent = new int[v];
            this.rank = new int[v];
            for(int i=0;i<v;i++){
                parent[i]=i;
            }
        }
        public boolean union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            //cycle exist
            if(pu==pv)return true;
            if(rank[pv]<rank[pu]){
                parent[pv] = pu;
            }else if(rank[pu]<rank[pv]){
                parent[pu] = pv;
            }else{
                parent[pu] = pv;
                rank[pv]++;
            }
            return false;
        }

        public int findParent(int u){
            if(u==parent[u]){
                return u;
            }
            parent[u] = findParent(parent[u]);
            return parent[u];
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        DisjointSet  ds = new DisjointSet(n);
        for(int[] edge :edges){
            if(ds.union(edge[0],edge[1])){
                return false;
            }
        }
        return true;
        // ArrayList<Integer> []adj = new ArrayList[n];
        // for(int i=0;i<n;i++){
        //     adj[i]=new ArrayList<>();   
        // }
        // for(int []edge: edges){
        //     adj[edge[0]].add(edge[1]);  
        //     adj[edge[1]].add(edge[0]);
        // }
        // int []visited = new int[n];
        // if (dfs(adj, 0, -1, visited)) {
        //     return false;
        // }

        // for (int i = 0; i < n; i++) {
        //     if (visited[i] == 0) {
        //         return false;
        //     }
        // }
        // return true;
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
