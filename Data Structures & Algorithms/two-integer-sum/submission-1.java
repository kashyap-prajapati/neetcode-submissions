class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int []ret = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                if(i>map.get(target-nums[i])){
                    ret[0]=map.get(target-nums[i]);
                    ret[1]=i;
                }else{
                    ret[0]=i;
                    ret[1]=map.get(target-nums[i]);
                }
            }else{
                map.put(nums[i],i);
            }
        }
        return ret;
    }
}
