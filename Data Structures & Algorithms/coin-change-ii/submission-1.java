class Solution {
    public int change(int amount, int[] coins) {
        int [][]mat = new int[coins.length+1][amount+1];
        for(int []m:mat){
            Arrays.fill(m,-1);
        }
        return dfs(coins,0,amount,mat);
    }

    public int dfs(int[]coins, int index ,int amount, int[][]mat){
        if(index==coins.length || amount<0){
            return 0;
        }
        if(coins[index]==amount){
            return 1;
        }
        if(amount==0){
            return 1;
        }
        if( mat[index][amount]!=-1){
            return mat[index][amount];
        }
        int take = dfs(coins,index,amount-coins[index],mat);
        int not_take = dfs(coins,index+1, amount,mat);
        mat[index][amount] = take + not_take;
        return mat[index][amount];
    }
}
