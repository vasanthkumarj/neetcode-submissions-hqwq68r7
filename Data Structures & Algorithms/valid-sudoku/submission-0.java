class Solution {
    public boolean isValidSudoku(char[][] board) {
        
      Map<Integer, Set<Character>> rowMap = new HashMap<>();
      Map<Integer, Set<Character>> columnMap = new HashMap<>();
      Map<String, Set<Character>> squareMap = new HashMap<>();


      for(int r = 0; r < 9; r++){
          for(int c = 0; c < 9; c++){
             
             if(board[r][c] == '.'){
               continue;
             }

             String squareKey = (r/3)+","+(c/3);

             if(rowMap.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
             || columnMap.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
             || squareMap.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])){
                return false;
             }

             rowMap.get(r).add(board[r][c]);
             columnMap.get(c).add(board[r][c]);
             squareMap.get(squareKey).add(board[r][c]);

          }
      }

      return true;


    }
}
