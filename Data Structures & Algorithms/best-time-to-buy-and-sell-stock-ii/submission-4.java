class Solution {
    public int maxProfit(int[] prices) {
        int [][]dp = new int[prices.length+1][2];
        int n = prices.length;
        for(int i=0;i<2;i++){
            dp[n][i]=0;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==0){
                    dp[i][j] = Math.max(dp[i+1][0], - prices[i] + dp[i+1][1]);
                }
                if(j==1){
                    dp[i][j] = Math.max(dp[i+1][1],  prices[i] + dp[i+1][0]);
                }
            }
        } 

        return dp[0][0];


       // return f(0,0,prices,dp);
    }



    // memoization
    //    for(int i=0;i<dp.length;i++){
    //        for(int j=0;j<dp[0].length;j++){
    //            dp[i][j]=-1;
    //        }
    //    }
    public int f(int index, int buy, int []prices, int [][] dp){
        if(index==prices.length){
            return 0;
        }

        if(dp[index][buy]!=-1){
            return dp[index][buy];
        }

        if(buy==0){
            int not_take = f(index+1,0,prices,dp);
            int take = -prices[index] + f(index+1, 1, prices,dp);
            dp[index][buy] = Math.max(not_take,take);
        }else{
            int not_take = f(index+1,1, prices,dp);
            int take = prices[index] + f(index+1,0,prices,dp);
            dp[index][buy] = Math.max(not_take,take);
        }
        return dp[index][buy];
    }
}