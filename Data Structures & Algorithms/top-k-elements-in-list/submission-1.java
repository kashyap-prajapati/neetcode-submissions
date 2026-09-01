class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int []arr  = new int[k];
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue().compareTo(b.getValue()));

        for (Map.Entry<Integer, Integer> m :map.entrySet()) {
            pq.add(m); 
            if(pq.size()>k){
               pq.poll();
            }
        }
       
        int i=0;
        while(!pq.isEmpty()){
            arr[i] = pq.poll().getKey();
            i++;
        }

        return arr;
    }
}
