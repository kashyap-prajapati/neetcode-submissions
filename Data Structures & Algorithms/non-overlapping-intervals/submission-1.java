class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[1]-b[1]);
        int nonoverlapping=1;
        int last_end_time = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            int []curr = intervals[i];
            if(last_end_time<=curr[0]){
                nonoverlapping++;
                last_end_time = curr[1];
            }
        }
        return intervals.length-nonoverlapping;
    }
}
