class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp =  new int[m][n];
        return path(m-1,n-1);
    }

    public int path(int i, int j){
        if(i==0 || j==0){
            return 1;
        }
        int up = path(i-1,j);
        int left = path(i,j-1);
        return up+left;
    }
}
