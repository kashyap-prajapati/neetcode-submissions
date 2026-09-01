class Solution {
    public int[] getOrder(int[][] tasks) {
        int[] ans = new int[tasks.length];
        int[][] tasklist = new int[tasks.length][3];

        for(int i=0;i<tasks.length;i++){
            tasklist[i][0] = tasks[i][0];
            tasklist[i][1] = tasks[i][1];
            tasklist[i][2] = i; 
        }
        Arrays.sort(tasklist,(a,b)->a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });

        int taskIndex=0;
        int time = 0;
        int index=0;
        while(taskIndex<tasks.length || !pq.isEmpty()){

            while(taskIndex<tasks.length && tasklist[taskIndex][0]<=time){
                pq.offer(tasklist[taskIndex]);
                taskIndex++;
            }

            if(!pq.isEmpty()){
                int[] task = pq.poll();
                time += task[1];
                ans[index++] = task[2];
            }else{
                time = tasklist[index][0];
            }
        }

        return ans;
    }
}