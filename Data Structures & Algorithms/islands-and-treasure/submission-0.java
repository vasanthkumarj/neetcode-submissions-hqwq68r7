class Solution {
    private static final int INF = 2147483647;
    int rows;
    int cols;
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0) return;

        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        rows = grid.length;
        cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 0){
                    queue.offer(new int[]{row, col});
                }
            }
        }


        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cr = current[0];
            int cc = current[1];

            for(int[] direction : directions){
                int nr = direction[0] + cr;
                int nc = direction[1] + cc;

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == INF){
                    grid[nr][nc] = 1 + grid[cr][cc];
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

    }

    
}
