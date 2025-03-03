package edu.uoc.pac1;

public class PAC1Ex3 {

    public static int MAX_ROWS = 6;
    public static int MAX_COLUMNS = 7;

    public static boolean isValidColumn(char[][] board, int column) {
        boolean validColumn=false;

        if (column > board.length || column < 0) return validColumn;

        for(int row = MAX_ROWS - 1; row >= 0; row--) {
            if(board[row][column]==' '){
               validColumn=true;
               break;
            }

        }

        return validColumn;

    }

    public static void printBoard(char[][] board) {
        String result = "";
        for (int row=0; row<MAX_ROWS; row++){
            result +="|";
            for (int column=0; column<MAX_COLUMNS; column++){
                result += board[row][column]+"|";
            }
            result += System.lineSeparator();
        }

        System.out.print(result);
    }

    public static boolean checkWinHorizontal(char[][] board, char color) {

        char previousColor='0';
        int count;
        for (int row=0; row<MAX_ROWS; row++){
            count=0;
            for (int column=0; column<MAX_COLUMNS; column++){
                if (board[row][column] == color && (previousColor == color || previousColor == '0')){
                    count++;
                } else{
                    count=0;
                }
                if (count == 4){
                    return true;
                }
                previousColor=color;
            }
        }
        return false;
    }


    public static boolean checkWinVertical(char[][] board, char color) {
        char previousColor='0';
        int count;
        for (int column=0; column<MAX_COLUMNS; column++){
            count=0;
            for (int row=0; row<MAX_ROWS; row++){
                if (board[row][column] == color && (previousColor == color || previousColor == '0')){
                    count++;
                } else{
                    count=0;
                }
                if (count == 4){
                    return true;
                }
                previousColor=color;
            }
        }
        return false;
    }

    public static boolean checkWinDiagonal(char[][] board, char color) {
        //TODO
        boolean winD =false;
        int flag=0;
        int row;
        int column;
        char previous=' ';
        //First square
        for (row=0; row<3; row++) {
            column=0;
            do {
                previous = board[row][column];
                row++;
                column++;
                if (previous == color) {
                    flag++;
                } else {
                    flag = 0;
                }
            } while (row < MAX_ROWS);
        }
        if (flag==4){
            winD=true;
        }
        //Second Square
        for (row=MAX_ROWS-1; row<=0; row--) {
            column=0;
            do {
                previous = board[row][column];
                row--;
                column++;
                if (previous == color) {
                    flag++;
                } else {
                    flag = 0;
                }
            } while (row >=0);
        }
        if (flag==4){
            winD=true;
        }
        //Third square
        for (row=0; row<3; row++) {
            column=MAX_COLUMNS-1;
            do {
                previous = board[row][column];
                row++;
                column--;
                if (previous == color) {
                    flag++;
                } else {
                    flag = 0;
                }
            } while (row < MAX_ROWS);

        }
        if (flag==4){
            winD=true;
        }
        //Fourth Square
        for (row=MAX_ROWS-1; row<=0; row--) {
            column=MAX_COLUMNS-1;
            do {
                previous = board[row][column];
                row--;
                column--;
                if (previous == color) {
                    flag++;
                } else {
                    flag = 0;
                }
            } while (row >=0);
        }
        if (flag==4){
            winD=true;
        }


        return winD;
    }

    public static boolean checkWin(char[][] board, char color) {
        return checkWinHorizontal(board, color) ||
                checkWinVertical(board, color) ||
                checkWinDiagonal(board, color);
    }

    public static char[][] dropPiece(char[][] board, int column, char color) {
        //TODO
        // check con method isValidColumn
        if (isValidColumn(board, column)) {

            for (int row = MAX_ROWS-1; row >=0; row--) {
                if (board[row][column]==' '){
                    board[row][column]=color;
                    break;
                }
            }

            printBoard(board);
            if (checkWin(board, color)) {
                System.out.println("Color " + color + " wins!");
            }

        } else {
            System.out.print("This column is invalid or full.");
        }
        return board;
    }

}
