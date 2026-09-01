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
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<intervals.size();i++){
           if(!pq.isEmpty() && pq.peek()<=intervals.get(i).start){
                pq.poll();
           }
           pq.offer(intervals.get(i).end);
        }
        return pq.size();

    }
}
