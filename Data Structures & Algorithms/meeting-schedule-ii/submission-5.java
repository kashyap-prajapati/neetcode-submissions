/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // for(int i=0;i<intervals.size();i++){
        //    if(!pq.isEmpty() && pq.peek()<=intervals.get(i).start){
        //         pq.poll();
        //    }
        //    pq.offer(intervals.get(i).end);
        // }
        // return pq.size();
        int n = intervals.size();
        int []start = new int[n];
        int []end = new int[n];
        int i=0;
        for(Interval interval:intervals){
            start[i]= interval.start;
            end[i] = interval.end;
            i++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int startIndex = 0;
        int endIndex = 0;
        int rooms = 0;
        int max = 0;
        while(startIndex < n && endIndex < n){
            if(start[startIndex] < end[endIndex]){
                rooms++;
                max = Math.max(rooms, max);
                startIndex++;
            }else{  
                rooms--;
                endIndex++;
            }
        }

        return max;

    }
}
