class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices,0,0);
    }

    public int dfs(int []prices, int  index, int  buy){
        if(index>=prices.length){
            return 0;
        }

        if(buy==0){
            int take = -prices[index] + dfs(prices,index+1,1);
            int not_take = dfs(prices,index+1,0);
            return Math.max(take,not_take);        
        }else{
            int take = prices[index] + dfs(prices,index+2,0);
            int not_take = dfs(prices,index+1,1);
            return Math.max(take,not_take); 
        }

    }


}
