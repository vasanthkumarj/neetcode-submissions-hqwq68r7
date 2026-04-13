class Solution {
    int n;
    int m;
    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        boolean[][] pacificVisited = new boolean[n][m];
        boolean[][] atlanticVisited = new boolean[n][m];

        for(int i = 0; i < m; i++){
            dfs(0, i, heights, pacificVisited);
            dfs(n-1, i, heights, atlanticVisited);
        }

        for(int i = 0; i < n; i++){
            dfs(i, 0, heights, pacificVisited);
            dfs(i, m-1, heights, atlanticVisited);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] visited){
        visited[row][col] = true;

        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m 
            || visited[newRow][newCol] 
            || heights[newRow][newCol] < heights[row][col]) continue;

            dfs(newRow, newCol, heights, visited);
        }

    }
}
