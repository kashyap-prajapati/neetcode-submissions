class Solution {
    public List<List<String>> solveNQueens(int n) {
        int [][] board = new int[n][n];
        List<List<String>> ans =  new ArrayList<>();
        putqueen(0,board,n,ans);
        return ans;
    }

    public void putqueen(int col, int[][]board, int n,List<List<String>> ans){
        if(col==n){
             List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++){
                String str="";
                for(int j=0;j<n;j++){
                    str = str + (board[i][j]==1?"Q":".");
                }
                temp.add(str);
            }
             ans.add(temp);
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col]=1;
                putqueen(col+1,board,n,ans);
                board[row][col]=0;
            }
        }
    }

    public boolean isSafe(int row, int col, int [][] board, int n){
        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(board[i][j]==1) return false;
            i--;
            j--;
        }

        i=row;
        j=col;
        while(j>=0){
            if(board[i][j]==1)return false;
            j--;
        }

        i=row;
        j=col;
        while(i<n && j>=0){
            if(board[i][j]==1)return false;
            i++;
            j--;
        }

        return true;
    }
}
