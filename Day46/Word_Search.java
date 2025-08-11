class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(exist(board,i,j,word,0)) return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int i, int j, String word, int idx){
        if(idx == word.length()) return true;
        if(i<0 || i==board.length || j<0 || j==board[0].length || board[i][j] == '.') return false;
        if(board[i][j] != word.charAt(idx)) return false;

        board[i][j] = '.';   // mark as visited
        boolean result =    exist(board, i-1, j, word, idx+1) ||
                            exist(board, i, j-1, word, idx+1) ||
                            exist(board, i, j+1, word, idx+1) ||
                            exist(board, i+1, j, word, idx+1);
        board[i][j] = word.charAt(idx); // unmark
        return result;
    }
}