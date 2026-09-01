class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        Stack<int[]> pq = new Stack<>();
        for(int []interval:intervals){
           
            if(!pq.isEmpty() &&  pq.peek()[1]>=interval[0]){
                int[] prev = pq.pop();
                int[] merge = new int[2];
                merge[0] = Math.min(prev[0],interval[0]);
                merge[1] = Math.max(prev[1],interval[1]);
                System.out.println(prev[0]+" "+prev[1]+"-"+interval[0] +" "+interval[1]+"-"+merge[0]+" "+merge[1]);
                pq.push(merge);
            }else{
                pq.push(interval);
            }
        }

        int [][]ans = new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++] = pq.pop();
        }    
        return ans;
    }
}
