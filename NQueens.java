package Java;
import java.util.*;

public class NQueens {
    public static boolean isSafe(int row, int col, char[][] boards) {
        //vertical
        for(int i=0; i<boards.length; i++) {
            if(boards[i][col] == 'Q')
            return false;
        }
        //horizontal
        for(int i=0; i<boards.length; i++) {
            if(boards[row][i] == 'Q')
            return false;
        }
        //upper left
        int r=row;
        for(int c=col; r>=0 && c>=0; r--, c--) {
            if(boards[r][c] == 'Q')
            return false;
        }
        //lower left
        r=row;
        for(int c=col; c>=0 && r<boards.length; c--, r++) {
            if(boards[r][c] == 'Q')
            return false;
        }
        //upper right
        r=row;
        for(int c=col; r>=0 && c<boards.length; c++,r--) {
            if(boards[r][c] == 'Q')
            return false;
        }
        //lower right
        r=row;
        for(int c=col; r<boards.length && c<boards.length; r++,c++) {
            if(boards[r][c] == 'Q')
            return false;
        }
    
        return true;
    }

    public static void saveBoards(char[][] boards, List<List<String>> allBoards) {
        String row = "";
        List<String> newBoards = new ArrayList<>();

        for(int i=0; i<boards.length; i++) {
            row = "";
            for(int j=0; j<boards.length; j++) {
                if(boards[i][j] == 'Q')
                row += 'Q';
                else
                row += '.';
            }
            newBoards.add(row);
        }
        allBoards.add(newBoards);
    }   

    public static void helper(char[][] boards,List<List<String>> allBoards, int col) {
        if(col == boards.length){
            saveBoards(boards,allBoards);
            return;
        }

        for(int row=0; row<boards.length; row++) {
            if(isSafe(row,col,boards)) {
                boards[row][col] = 'Q';
                helper(boards, allBoards, col+1);
                boards[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] boards = new char[n][n];

        helper(boards,allBoards,0);
        return allBoards;
    }
    
    public static void main(String args[]) {
        int n = 5;
        List<List<String>> solutions = solveNQueens(n);
        //System.out.println(solutions);

        for(List<String> board : solutions) {
            for(String row : board) {
                System.out.println(row);
            }
            //blank lines btw boards
            System.out.println();
        }
    }
}
