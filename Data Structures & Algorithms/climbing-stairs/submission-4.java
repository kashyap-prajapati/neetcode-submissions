class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        //return f(n,dp);       
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n]; 
    }

    public int f(int index,int[] dp){
        if(index==0) return 1;
        if(index==1) return 1;
        if(dp[index]!=0) return dp[index];
        dp[index] = f(index-1,dp) + f(index-2,dp);
        return dp[index];
    }
}
