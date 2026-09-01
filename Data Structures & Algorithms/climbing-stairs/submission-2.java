class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        return f(n,dp);        
    }

    public int f(int index,int[] dp){
        if(index==0) return 1;
        if(index==1) return 1;
        if(dp[index]!=0) return dp[index];
        dp[index] = f(index-1,dp) + f(index-2,dp);
        return dp[index];
    }
}
