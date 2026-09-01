class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int v=numCourses;
        ArrayList<Integer> []adj = new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i] = new ArrayList<>();
        }
        int []inDegree = new int[v];
        for(int []prerequisite:prerequisites){
            adj[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<v;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        if(queue.isEmpty()){
            return false;
        }

        int count=0;
        while(!queue.isEmpty()){
            count++;
            int node = queue.poll();
            for(int it:adj[node]){
                inDegree[it]--;
                if(inDegree[it]==0){
                    queue.add(it);
                }
            }
        }

        return count==v;
    }
}
