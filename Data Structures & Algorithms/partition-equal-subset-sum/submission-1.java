class Solution {
    public boolean canPartition(int[] nums) {
     
        int sum=0;
        for(int num:nums){
            sum = sum + num;
        }
        if(sum%2==1){
            return false;
        }
        int target = sum/2;
        int [][] dp  = new int[nums.length][target+1];
        return partition(nums, nums.length-1,target,dp);
    }

    public boolean partition(int[] nums,int index, int target,int[][] dp){

        if(target==0)return false;
        if(index==0)return nums[0]==target;

        if(dp[index][target]!=0){
            return dp[index][target]==1;
        }
        boolean notTake = partition(nums, index-1,target,dp);
        boolean take = false;
        if(target>=nums[index]){
            take = partition(nums,index-1,target-nums[index],dp);
        }
        dp[index][target] = notTake || take ? 1 : 0;
        return dp[index][target]==1;
    }
}
