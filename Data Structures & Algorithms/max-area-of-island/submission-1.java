class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] visited = new int[m][n];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && visited[i][j]==0)
                    max = Math.max(max, getArea(grid,m,n,i,j,visited));
            }
        }
       return max==Integer.MIN_VALUE?0:max;
    }

    public int getArea(int [][] grid, int m, int n, int row, int col, int[][] visited){
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(row,col));
        visited[row][col]=1;
        int area=1;
        while(!queue.isEmpty()){
            Pair<Integer,Integer> p = queue.poll();
            int i=p.getKey();
            int j=p.getValue();

            for(int dir=-1;dir<=1;dir++){
                if(i+dir>=0 && i+dir<m && grid[i+dir][j]==1 && visited[i+dir][j]==0){
                    visited[i+dir][j]=1;
                    queue.add(new Pair<>(i+dir,j));
                    area++;
                }else if(j+dir>=0 && j+dir<n && grid[i][j+dir]==1 && visited[i][j+dir]==0){
                    visited[i][j+dir]=1;
                    queue.add(new Pair<>(i,j+dir));
                    area++;
                }
            }
        }
        return area;
    }
}
