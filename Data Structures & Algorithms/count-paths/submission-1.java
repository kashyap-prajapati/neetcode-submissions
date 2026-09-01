class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp =  new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
        // return path(m-1,n-1,dp);
    }

    public int path(int i, int j, int [][] dp){
        if(i==0 || j==0){
            return 1;
        }
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int up = path(i-1,j,dp);
        int left = path(i,j-1,dp);
        dp[i][j] = up+left;
        return dp[i][j];
    }
}
