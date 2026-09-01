class Solution {
    public int rob(int[] nums) {
        int []dp =  new int[nums.length];
        return f(nums,nums.length-1,dp);
    }

    public int f(int[] nums, int index,int [] dp){
        if(index==0) return nums[0];
        if(dp[index]!=0) return dp[index];
        int fs = nums[index] ;
        if(index > 1) fs = fs + f(nums,index-2,dp);
        int ss = 0 + f(nums,index-1,dp);
        dp[index] =  Math.max(fs,ss);
        return dp[index];
    }
}
