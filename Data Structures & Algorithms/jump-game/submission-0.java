class Solution {
    public boolean canJump(int[] nums) {
        int max_reach=0;
        for(int i=0;i<nums.length;i++){
            int jump_reach = i + nums[i];
            if(i>max_reach){
                return false;
            }
            max_reach = Math.max(jump_reach,max_reach);
        }
        return true;
    }
}
