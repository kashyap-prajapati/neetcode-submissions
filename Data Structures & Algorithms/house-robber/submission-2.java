class Solution {
    public int rob(int[] nums) {
        int []dp =  new int[nums.length];
        dp[0] = nums[0];
        for(int index=1;index<nums.length;index++){
            int fs = nums[index] ;
            if(index > 1) fs = fs + dp[index-2];
            int ss = 0 + dp[index-1];
            dp[index] =  Math.max(fs,ss);
        }
        return dp[nums.length-1];
 //       return f(nums,nums.length-1,dp);
    }

    //MEMP - TOP DOWN
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
