class Solution {
    public void islandsAndTreasure(int[][] grid) {
        final int INF = 2147483647;

        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 0){
                    queue.offer(new int[]{row, col, 0});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];
            int currentLevel = current[2];
            
            for(int[] direction : directions){
                int newRow = currentRow + direction[0];
                int newCol = currentCol + direction[1];

                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols 
                || grid[newRow][newCol] != INF){
                    continue;
                }

                queue.offer(new int[]{newRow, newCol, currentLevel+1});
                grid[newRow][newCol] = currentLevel+1;
            }
        }
    }
}
