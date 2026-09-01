class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]> []adj = new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int []time:times){
            adj[time[0]].add(new int[]{time[1], time[2]});
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k,0});

        int[] distance = new int[n+1];
        for(int i=1;i<=n;i++){
            distance[i] = Integer.MAX_VALUE; 
        }

        distance[k]=0;

        while(!q.isEmpty()){
            int []curr = q.poll();
            int node = curr[0];
            int weight = curr[1];
            for(int []ne : adj[node]){
                if(distance[ne[0]] > weight + ne[1]){
                    distance[ne[0]] = weight + ne[1];
                    q.offer(new int[]{ne[0],weight + ne[1]});
                }
            }
        }

        for(int i=1;i<=n;i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
        }
        
        int max = 0;
        for(int i=1;i<=n;i++){
            max = Math.max(max,distance[i]);
        }

        return max;
    }

}
