/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
        
        for(ListNode list:lists){
            if(list!=null)
                minHeap.offer(list);
        }

        ListNode tail=new ListNode(-1);
        ListNode dummy = tail;
        while(!minHeap.isEmpty()){
            ListNode temp = minHeap.poll();
            tail.next=temp;
            if(temp.next!=null){
                minHeap.offer(temp.next);
            }
            tail=tail.next;
            temp.next=null;
        }
        return dummy.next;
    }
}
