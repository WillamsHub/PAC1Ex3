package edu.uoc.pac1;

public class PAC1Ex3 {

    public static int MAX_ROWS = 6;
    public static int MAX_COLUMNS = 7;

    public static boolean isValidColumn(char[][] board, int column) {
        //TODO
        boolean validColumn=false;
        if (column > 0 || column < MAX_COLUMNS){
            for(int row = MAX_ROWS - 1; row >= 0; row--) {
                if(board[row][column]==' '){
                   validColumn=true;
                   break;
                }

            }
        }

        return validColumn;

    }

    public static void printBoard(char[][] board) {
        //TODO
        char[][] matriz = {
                {'R', 'Y', ' ', ' ', ' ', ' ', ' '},
                {'Y', 'R', 'R', ' ', ' ', ' ', ' '},
                {'R', 'Y', 'R', ' ', ' ', ' ', ' '},
                {'Y', 'R', 'Y', 'R', ' ', ' ', ' '},
                {'R', 'Y', 'Y', 'Y', ' ', ' ', ' '},
                {'Y', 'R', 'R', 'R', 'Y', ' ', ' '}
        };
        for (int column = 0; column < MAX_COLUMNS; column++) {
            for (int row = 0; row < MAX_ROWS; row++) {
                board[row][column] = matriz[row][column];
            }
        }

    }

    public static boolean checkWinHorizontal(char[][] board, char color) {
        //TODO
        boolean winH=false;
        int flag=0;
        char previous = color;
        do {
            for (int row = 0; row < MAX_ROWS; row++) {
                flag = 0;
                for (int column = 0; column < MAX_COLUMNS; column++) {
                    previous=board[row][column];
                    if (previous == color) {
                        flag++;
                    }
                }
            }
        } while(previous==color);
        if(flag==4){
            winH=true;
        }

        return winH;
    }


    public static boolean checkWinVertical(char[][] board, char color) {
        //TODO
        boolean winV =false;
        int flag=0;
        char previous = color;
        do {
            for (int column = 0; column < MAX_COLUMNS; column++) {
                flag = 0;
                for (int row = 0; row < MAX_ROWS; row++) {
                    previous=board[row][column];
                    if (previous == color) {
                        flag++;
                    }
                }
            }
        } while(previous==color);
        if(flag==4){
            winV =true;
        }

        return winV;
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
        //TODO
        
    }

    public static char[][] dropPiece(char[][] board, int column, char color) {
        //TODO
    }

}
