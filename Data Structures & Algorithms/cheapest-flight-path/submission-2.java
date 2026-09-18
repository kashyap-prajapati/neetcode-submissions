class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<int[]>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>(); 
        } 
        int []dest = new int[n];
        Arrays.fill(dest, Integer.MAX_VALUE);

        for(int []flight:flights){
            graph[flight[0]].add(new int[]{flight[1],flight[2]});
        }

        // src, cost, k
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{src,0,0});
        dest[src]=0;

        while(!queue.isEmpty()){
            int []curr = queue.poll();
            int stop = curr[2];
            if(stop>k)continue;
            int node = curr[0];
            int c = curr[1];
            for(int []ne:graph[node]){
                int nc = ne[1];
                if(dest[ne[0]] > c + nc){
                    dest[ne[0]] = c + nc;
                    queue.offer(new int[]{ne[0], dest[ne[0]], stop+1});
                } 
            }   
        }

        return dest[dst]==Integer.MAX_VALUE?-1:dest[dst];
        //0 = {1, 200, 1}
        // List<int[]> []adj = new ArrayList[n];

        // for(int i=0;i<n;i++){
        //     adj[i] = new ArrayList<>();
        // }
        // for(int []flight:flights){
        //     adj[flight[0]].add(new int[]{flight[1],flight[2]});
        // }

        // int [][]dist = new int[n][k+2];

        // for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        // dist[src][0] = 0;

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        // pq.offer(new int[]{src,0,0});
        // while(!pq.isEmpty()){

        //     int []curr = pq.poll();
        //     int node = curr[0];
        //     int distance = curr[1];
        //     int steps = curr[2];
        //     if(node == dst) return distance;
        //     if(steps > k) continue;

        //     for(int []ne : adj[node]){
        //         int next = ne[0];
        //         int next_distance = ne[1];
        //         if(distance+next_distance  < dist[next][steps+1]){
        //             dist[next][steps+1] = distance+next_distance;
        //             pq.offer(new int[]{next,distance+next_distance,steps+1});
        //         }
        //     }

        // }
        // return -1;


    }
}
