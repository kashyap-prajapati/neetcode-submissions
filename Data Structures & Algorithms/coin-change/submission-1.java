class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][]dp = new int[coins.length][amount+1];
       
        for(int i=0;i<amount+1;i++){
            dp[0][i]=0;
        }
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<amount+1;j++){
                int nottake = Integer.MAX_VALUE;
                if(i-1>= 0){
                    nottake =  0 + dp[i-1][j];
                } 
                int take=Integer.MAX_VALUE;
                if(j>=coins[i]){
                    take = dp[i][j-coins[i]];
                    if(take!=Integer.MAX_VALUE) take++;            
                }
                dp[i][j]=Math.min(take, nottake);
            }
        }
//        int ans =min(coins, coins.length-1, amount,dp);
        return dp[coins.length-1][amount]==Integer.MAX_VALUE?-1:dp[coins.length-1][amount];
    }

    public int min(int []coins, int index, int amount, int [][]dp){
       
        if(amount==0){
            return 0;
        }
        if(amount<0 || index<0){
            return Integer.MAX_VALUE;
        }
        if(dp[index][amount]!=0){
            return dp[index][amount];
        }
       
        int nottake = 0 + min(coins, index-1, amount,dp);
        int take=Integer.MAX_VALUE;
        if(amount>=coins[index]){
            take = min(coins, index, amount-coins[index],dp);
            if(take!=Integer.MAX_VALUE) take++;
        }
        dp[index][amount]=Math.min(take, nottake);
        return dp[index][amount];
    }
}
