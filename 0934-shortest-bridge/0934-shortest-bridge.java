class Solution {
    private int[][] dirs = {{1 ,0} , {-1 , 0} ,{0 , 1},{0 , -1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for(int r = 0; r < n; r++){
            if(found) break;
            for(int c = 0;c < n ; c++){
                if(grid[r][c] == 1){
                    dfs(grid ,r,c,queue);
                    found = true;
                    break;
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ;i<size; i++){
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for( int[] dir : dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < n){
                        if(grid[nr][nc] == 1){
                            return distance;
                        }else if (grid[nr][nc] == 0){
                            grid[nr][nc] = -1;
                            queue.offer(new int[]{nr , nc});
                        } 
                    }
                }
            }
            distance++;
        }
        return distance;
    }
    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue){
        if(r<0 || r>=grid.length || c<0 || c>= grid[0].length || grid[r][c] != 1){
            return;
        }
        grid[r][c] = 2;
        queue.offer(new int[]{r , c});
        for(int[] dir : dirs){
            dfs(grid, r + dir[0], c + dir[1], queue);
        }
    }
}