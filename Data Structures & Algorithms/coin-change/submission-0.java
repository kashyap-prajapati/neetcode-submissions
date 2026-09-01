class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][]dp = new int[coins.length][amount+1];
        int ans =min(coins, coins.length-1, amount,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
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
