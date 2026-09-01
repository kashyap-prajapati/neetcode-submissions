class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][]visited = new int[m][n];
        return getTime(grid,visited,m,n);
    }

    public int getTime(int [][]grid, int [][]visited, int m, int n){
        Queue<Pair<Pair<Integer, Integer>,Integer>> queue = new LinkedList<>();
        for(Integer i=0;i<m;i++){
            for(Integer j=0;j<n;j++){
                if(grid[i][j]==2){
                    visited[i][j]=1;
                    queue.add(new Pair<>(new Pair<>(i,j), 0));
                }   
            }
        }
        Integer time=0;
        while(!queue.isEmpty()){
            Pair<Pair<Integer,Integer>,Integer> v = queue.poll();
            Integer row = v.getKey().getKey();
            Integer col = v.getKey().getValue();
            Integer level= v.getValue();
            time = Math.max(level,time);
            Integer [][]dirs = new Integer[][]{{1,0},{-1,0},{0,1},{0,-1}};
             for(Integer []dir:dirs){
                if(row+dir[0]>=0 && row+dir[0]<m && col+dir[1]>=0 && col+dir[1]<n && 
                    grid[row+dir[0]][col+dir[1]]==1 && visited[row+dir[0]][col+dir[1]]==0){
                    visited[row+dir[0]][col+dir[1]]=1;
                    queue.add(new Pair<>(new Pair<>(row+dir[0],col+dir[1]),level+1));
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    return -1;
                }   
            }
        }
        return time;
    }
}
