class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map<Integer,Integer> map = new HashMap<>();
        // int []arr  = new int[k];
        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0)+1);
        // }

        // PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->a.getValue().compareTo(b.getValue()));

        // for (Map.Entry<Integer, Integer> m :map.entrySet()) {
        //     pq.add(m); 
        //     if(pq.size()>k){
        //        pq.poll();
        //     }
        // }
       
        // int i=0;
        // while(!pq.isEmpty()){
        //     arr[i] = pq.poll().getKey();
        //     i++;
        // }

        // return arr;

        List<Integer> []buckets = new List[nums.length+1];
        Map<Integer, Integer> freq = new HashMap<>();
         for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(int n:nums){
            freq.merge(n,1, Integer::sum);
        }
        for(Map.Entry<Integer, Integer> entry:freq.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }

        int []res = new int[k];
        int index=0;
        for(int i=buckets.length-1;i>0 && index<k;i--){
            for(int n:buckets[i]){
                res[index++]=n;
                if(index==k){
                    return res;
                }
            }
        }
        return res;
    }
}
