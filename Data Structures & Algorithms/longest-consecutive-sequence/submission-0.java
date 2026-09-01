class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int max=0;        
        for(int num:nums){
            if(!set.contains(num-1)){
                int exist=num;
                int count=0;
                while(set.contains(exist)){
                    exist++;
                    count++;
                }
                max = Math.max(count,max);
            }   
        }
        return max;
    }
}
