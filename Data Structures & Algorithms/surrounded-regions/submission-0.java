class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        Queue<int []> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(board[i][0]=='O')
                q.add(new int[]{i,0});
            if(board[i][n-1]=='O')    
                q.add(new int[]{i,n-1});
            
        }
        for(int j=0;j<n;j++){
            if(board[0][j]=='O')
                q.add(new int[]{0,j});
            if(board[m-1][j]=='O')
                q.add(new int[]{m-1,j});
            
        }

        int [][]dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int []curr = q.poll();
            board[curr[0]][curr[1]] = '#';
            for(int []dir:dirs){
                int x = curr[0]+dir[0];
                int y = curr[1] + dir[1];
                if(x<0 ||y<0 ||x>=m ||y>=n) continue;
                // if(board[x][y]=='#')continue;
                if(board[x][y]=='O'){
                    board[x][y] = '#';
                    q.add(new int[]{x,y});
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
