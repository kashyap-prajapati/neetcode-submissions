class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int max_reach=0;
        int count=1;
        for(int i=0;i<nums.length;i++){
            int jump = i+nums[i];
            if(jump>max_reach){
                max_reach=jump;
            }
            nums[i] = max_reach;
        }
        int index=nums[0];
        while(index<nums.length-1 && index!=nums.length-1){
            count++;
            index = nums[index];
        }
        return count;
    }
}
