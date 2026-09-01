class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ans=false;
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                int [][] visited = new int[board.length][board[row].length];
                if(found(board, word, "",row,col,visited)){
                    return true;
                }
            }
        }
        return ans;
    }

    public boolean found(char[][] board,String word,String temp, int i, int j, int[][] visited){
        if(word.length()==temp.length()){
            if(word.equals(temp)){
                return true;
            }else{
                return false;
            }
        }
        if(i<0 || j<0){
            return false;
        }
        if(i>board.length-1){
            return false;
        }
        if(j>board[i].length-1){
            return false;
        }
        if(temp.length()>word.length()){
            return false;
        }

        
        boolean right = false;
        boolean down = false;
       
        if(visited[i][j]==0){
            visited[i][j]=1;
            right = right || found(board, word, temp+board[i][j],i+1,j,visited); 
            visited[i][j]=0;
            visited[i][j]=1;
            right = right || found(board, word, temp+board[i][j],i-1,j,visited);
            visited[i][j]=0;
            visited[i][j]=1;
            down = down || found(board, word, temp+board[i][j],i,j+1,visited);
            visited[i][j]=0;
            visited[i][j]=1;
            down = down || found(board, word, temp+board[i][j],i,j-1,visited);
            visited[i][j]=0;
        }
      
       
   
        return right || down;
    }
}
