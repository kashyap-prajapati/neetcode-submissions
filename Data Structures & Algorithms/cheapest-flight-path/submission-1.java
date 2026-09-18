class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        //0 = {1, 200, 1}
        List<int[]> []adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int []flight:flights){
            adj[flight[0]].add(new int[]{flight[1],flight[2]});
        }

        int [][]dist = new int[n][k+2];

        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src,0,0});
        while(!pq.isEmpty()){

            int []curr = pq.poll();
            int node = curr[0];
            int distance = curr[1];
            int steps = curr[2];
            if(node == dst) return distance;
            if(steps > k) continue;

            for(int []ne : adj[node]){
                int next = ne[0];
                int next_distance = ne[1];
                if(distance+next_distance  < dist[next][steps+1]){
                    dist[next][steps+1] = distance+next_distance;
                    pq.offer(new int[]{next,distance+next_distance,steps+1});
                }
            }

        }
        return -1;


    }
}
