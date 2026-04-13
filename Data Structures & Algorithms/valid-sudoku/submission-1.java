class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set> rowMap = new HashMap<>();
        Map<Integer, Set> colMap = new HashMap<>();
        Map<String, Set> gridMap = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')continue;

                String key = (i/3)+"-"+(j/3);
                if(!rowMap.computeIfAbsent(i, v -> new HashSet()).add(board[i][j])
                || !colMap.computeIfAbsent(j, v -> new HashSet()).add(board[i][j])
                || !gridMap.computeIfAbsent(key, v -> new HashSet()).add(board[i][j])){
                    return false;
                }
            }
        }

        return true;
    }
}
