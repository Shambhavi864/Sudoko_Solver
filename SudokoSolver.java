public class SudokoSolver {
    public static boolean isSafe(int[][] board, int digit, int row, int col){
        //row
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == digit){
                return false;
            }
        }

        //column
        for(int j=col-1; j>=0; j--){
            if(board[row][j] == digit){
                return false;
            }
        }

        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j]==digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean findsoln(int[][] board, int row, int col){
        if(row == 9){
            printboard(board);
            return true;
        }

        int newRow = row;
        int newCol = col+1;

        if(col+1 == 9){
            newRow = row+1;
            newCol = 0;
        }

        if(board[row][col]!=0){
            return findsoln(board, newRow, newCol);
        }

        for(int digits = 1; digits<=9; digits++){
            if(isSafe(board, digits, row, col)){
                board[row][col] = digits;
                if(findsoln(board, newRow, newCol)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void printboard(int[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j= 0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[9][9];

        findsoln(board, 0, 0);
    }
}