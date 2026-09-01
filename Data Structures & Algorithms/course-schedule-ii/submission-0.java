class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> []adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }
        int []inDegree = new int[numCourses];
        for(int []edge:prerequisites){
            adj[edge[1]].add(edge[0]);
            inDegree[edge[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i);
                ans.add(i);
            }
        }
        int count=0;

        while(!q.isEmpty()){
            count++;
            int cur = q.poll();
            for(int ne:adj[cur]){
                inDegree[ne]--;
                if(inDegree[ne]==0){
                    q.add(ne);
                    ans.add(ne);
                }
            }
        }
        
        
        if(count!=numCourses){
            return new int[]{};
        }
        int []result = new int[numCourses];
        int index=0;
        for(int course:ans){
            result[index++]=course;
        }
        return result;
    }
}
