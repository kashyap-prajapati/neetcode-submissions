class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        Integer [][]dp = new Integer[m][n];
        return dfs(word1, word2,m-1, n-1,m, n,dp);
    }
     int dfs(String word1, String word2, int i, int j, int m, int n, Integer[][] dp){
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if(dp[i][j]!=null){
            return dp[i][j];
        }
        
        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j] = dfs(word1,word2,i-1,j-1,m,n,dp);
            return dp[i][j];
        }else{
            int add = dfs(word1, word2, i-1,j, m,n,dp);
            int remove = dfs(word1,word2,i,j-1,m,n,dp);
            int replace = dfs(word1, word2, i-1,j-1,m,n,dp);
            dp[i][j] =  1+Math.min(add,Math.min(remove,replace));
            return dp[i][j];
        }

    }
}
