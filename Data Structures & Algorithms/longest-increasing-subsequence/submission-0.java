class Solution {
    public int lengthOfLIS(int[] nums) {
        int [][] dp = new int[nums.length][nums.length+1];
        return len(nums,0,-1,dp);
    }

    public int len(int []nums, int index, int prev, int [][]dp){
        if(nums.length==index){
            return 0;
        }
       
        if(prev!=-1 && dp[index][prev+1]!=0){
            return dp[index][prev+1];
        }

        int notTake = len(nums, index+1,prev,dp);
        int take = 0;
        if(prev==-1 || nums[index]>nums[prev]){
            take = 1 + len(nums, index+1, index,dp);
        }
        dp[index][prev+1]=Math.max(take, notTake);
        return dp[index][prev+1];
    }
}
