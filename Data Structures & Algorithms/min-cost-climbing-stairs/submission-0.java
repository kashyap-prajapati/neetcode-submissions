class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int [] dp = new int[cost.length];
        for(int i=0;i<cost.length;i++){
            dp[i]=-1;
        }
        return Math.min(f(cost, cost.length-1,dp),f(cost, cost.length-2,dp));
    }

    public int f(int[] cost, int n, int []dp){
        if(n==0 || n==1){
            return cost[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = cost[n] + Math.min(f(cost,n-1,dp),f(cost,n-2,dp));
        return dp[n];
    }
}
