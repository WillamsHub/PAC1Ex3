package edu.uoc.pac1;

public class PAC1Ex3 {

    public static int MAX_ROWS = 6;
    public static int MAX_COLUMNS = 7;

    public static boolean isValidColumn(char[][] board, int column) {
        boolean validColumn=false;

        if (column > board.length || column < 0) return validColumn;

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

       /* String result =   "| |Y|Y|R|R|Y|Y|" + System.lineSeparator() +
                            "| |R|R|Y|Y|R|R|" + System.lineSeparator() +
                            "| |Y|Y|R|R|Y|Y|" + System.lineSeparator() +
                            "| |R|R|Y|Y|R|R|" + System.lineSeparator() +
                            "| |Y|Y|R|R|Y|Y|" + System.lineSeparator() +
                            "| |R|R|Y|Y|R|R|" + System.lineSeparator();*/
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
        //TODO
        boolean winV =false;
        boolean win=false;
        int flagColor =0;
        int row=0;
        int column=0;
        int count=0;
        char previous=color;
        do{
            for(column=0; column<MAX_COLUMNS;column++) {
                for (row = 0; row < MAX_ROWS; row++) {
                    if (flagColor < 4) {
                        if (board[row][column] == color) {
                            if(previous==color){
                                flagColor++;
                                previous = board[row][column];

                            }

                        }

                    }
                    if (flagColor == 4) {
                        winV = true;
                        win = true;
                    }
                    count++;
                }
            }
        }while(count<42);

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
        boolean winH;
        boolean winV;
        boolean winD;
        boolean win;
        winH=checkWinHorizontal(board, color);
        winV=checkWinVertical(board, color);
        winD=checkWinDiagonal(board, color);
        if(winH||winV||winD){
            win=true;
        }
        win=false;
        return win;
    }

    public static char[][] dropPiece(char[][] board, int column, char color) {
        //TODO
        char[][] boardCheck=board;
        int row;
        int square=0;
        boolean validColumn = false;
        char[] check={' ', ' ', ' ', ' ', ' '};

        for (row=0; row<MAX_ROWS;row++){
            validColumn=false;
            check[row]=board[row][column];
            if(check[row]==' '){
                square=row;
                validColumn=true;
                row=MAX_ROWS;
            }

        }
        if(validColumn){
            boardCheck[square][column]=color;
        }
        else{
            System.out.println("This column is invalid or full");
        }
        return boardCheck;
    }

}
