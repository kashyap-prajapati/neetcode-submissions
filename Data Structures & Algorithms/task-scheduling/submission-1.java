class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []freqs = new int[26];
        for(char ch : tasks){
            freqs[ch-'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int freq:freqs){
            if(freq>0) maxHeap.offer(freq);
        }

        int time=0;
        Queue<int[]> q = new LinkedList<>();

        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            
            if(!maxHeap.isEmpty()){
               
                int cnt = maxHeap.poll()-1;
                if(cnt>0){
                    q.add(new int[]{cnt, time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;

        
    }
}
