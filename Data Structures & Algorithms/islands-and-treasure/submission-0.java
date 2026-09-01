class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Pair<Integer,Integer>,Integer>> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    q.add(new Pair<>(new Pair<>(i,j),0));
                }
            }
        }

        int [][]dirs =new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            Pair<Pair<Integer,Integer>,Integer> p = q.poll();
            Pair<Integer, Integer> curr = p.getKey();
            int level = p.getValue();
            for(int []dir:dirs){
                int x = curr.getKey()+dir[0];
                int y = curr.getValue()+dir[1];
                if(x<0 || y<0 || x>=m || y>=n)continue;
                if(grid[x][y]==-1)continue;
                if(grid[x][y]!=0){
                    if(level < grid[x][y]){
                        grid[x][y] = level+1;
                        q.offer(new Pair<>(new Pair<>(x,y),level+1));
                    }
                }
            }
        }
    }
}
