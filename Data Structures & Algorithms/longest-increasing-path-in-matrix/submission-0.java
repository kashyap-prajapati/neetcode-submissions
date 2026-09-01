class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max,dfs(matrix,m,n,i,j,Integer.MIN_VALUE));
            }
        }
        return max;
    }

    int dfs(int [][]matrix, int m , int n, int i, int j, int prev){
        if(i<0 || j<0 || i>=m || j>=n || matrix[i][j]<=prev){
            return 0;
        }
        int res=1;
        int [][]dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int []dir:dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            res = Math.max(res, 1+dfs(matrix,m,n,r,c,matrix[i][j]));
        }
        return res;
    }
}
