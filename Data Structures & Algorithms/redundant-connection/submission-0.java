class Solution {
    public int[] findRedundantConnection(int[][] edges) {
       //disjoint set;
       int n = edges.length;
       int [] parent = new int[n+1];
       int [] rank = new int[n+1];
       for(int i=0;i<=n;i++){
            parent[i] = i;
       }

       for(int[] edge :edges){
            if(union(edge[0],edge[1], parent, rank)){
                return edge;
            }
       }
       return new int[]{};
    }

    public boolean union(int u, int v, int[] parent, int[] rank){
        int pu = findParent(u,parent);
        int pv = findParent(v,parent);
        if(pv==pu)return true;

        if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }else if(rank[pu] > rank[pv]){
            parent[pu] = pv;
        }else{
            parent[pu] = pv;
            rank[pv]++;
        }
        return false;
    }

    public int findParent(int u, int []parent){
        if(u == parent[u])
            return u;
        
        parent[u] = findParent(parent[u],parent);
        return parent[u];
    }

}
