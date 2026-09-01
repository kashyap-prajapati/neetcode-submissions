class Solution {
    public int maxProfit(int[] prices) {
        int [][]dp = new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }



        return f(0,0,prices,dp);
    }



    // memoization
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