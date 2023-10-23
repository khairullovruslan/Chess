public class Queen extends BasicFigure {


    Queen(int color, int col, int row) {
        super(color, col, row);

    }

    public boolean checkMove(int col, int row) {
        boolean fl_rook = false;
        if (col == this.col) {
            if (row > this.row) {
                for (int i = this.row + 1; i < row - 1; i++) {
                    System.out.println(i);
                    if (Board.gameBoard[col - 1][i] != 0) {
                        return false;
                    }
                }

            } else {
                for (int i = row + 1; i < this.row - 1; i++) {
                    if (Board.gameBoard[col - 1][i] != 0) {
                        return false;
                    }
                }

            }
            fl_rook = true;


        }
        if (row == this.row) {
            if (col > this.col) {

                for (int i = col - 1; i > this.col; i++) {
                    if (Board.gameBoard[i][row] != 0) {
                        return false;
                    }
                }
            } else {
                for (int i = this.col - 1; i > col; i++) {
                    if (Board.gameBoard[i][row] != 0) {
                        return false;
                    }
                }
            }
            fl_rook = true;


        }
        if (fl_rook) {

            return true;

        }
        if (Math.abs(col - this.col) == Math.abs(row - this.row)) {
            int count;
            if (this.col > col) {
                if (this.row < row) {
                    count = row -1;}
                else {
                    count = row + 1;
                    }
                for (int i = col + 1; i < this.col; i++) {
                    if (Board.gameBoard[i][count] != 0) {
                        return false;
                    }
                    if (this.row > row){
                        count++;}
                    else {
                        count--;
                    }
                }
            } else {
                if (this.row < row) {
                    count = this.row +1;}
                else {
                    count = this.row - 1;
                }
                for (int i = this.col + 1; i < col -1; i++) {
                    if (Board.gameBoard[i][count] != 0) {
                        return false;
                    }
                    if (this.row > row){
                        count--;}
                    else {
                        count++;
                    }

                }

            }
            return true;
        }
        return false;


    }

}
