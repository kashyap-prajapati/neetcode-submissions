class Solution {
    public int numIslands(char[][] grid) {
        int m =grid.length;
        int n = grid[0].length;

        int count=0;
        int [][] visited = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && visited[i][j]==0){
                    count++;
                    bfs(grid,visited,i,j,m,n);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int [][]visited, int i, int j, int m, int n){
        Queue<Pair<Integer,Integer>> queue  = new LinkedList<>();
        //isited[i][j]=1;
        queue.add(new Pair<>(i,j));
        while(!queue.isEmpty()){
            Pair<Integer,Integer> v = queue.poll();
            int row = v.getKey();
            int col = v.getValue();
            int [][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            for(int []dir:dirs){
                if(row+dir[0]>=0 && row+dir[0]<m && col+dir[1]>=0 && col+dir[1]<n && visited[row+dir[0]][col+dir[1]]==0 && grid[row+dir[0]][col+dir[1]]=='1'){
                    visited[row+dir[0]][col+dir[1]]=1;
                    queue.add(new Pair<>(row+dir[0],col+dir[1]));
                }
            }
        }
        
    }
}
