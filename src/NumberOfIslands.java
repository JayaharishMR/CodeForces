public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count=0;
        int rows=grid.length;
        int cols=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int i,int j){

        int rows=grid.length;
        int cols=grid[0].length;


        grid[i][j]='0';

        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};

        for(int k=0;k<4;k++){
            int nx=i+ dx[k];
            int ny=j+dy[k];
            if(nx>=0 && nx<rows && ny>=0 && ny<cols && grid[nx][ny]=='1'){
                dfs(grid,nx,ny);
            }
        }

    }
}
