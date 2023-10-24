public class Pawn extends BasicFigure {




    Pawn(int color, int col, int row){
        super(color, col, row);
    }
    public  boolean checkMove(int col, int row){

        if (color == 1){


            if ((this.col - col) != 1){
                return false;
            }
            if (row == this.row){
                return Board.gameBoard[col][row] == 0;
            }
            else return (Math.abs(this.row - row) <= 1) && (Board.gameBoard[col][row] > 0);
        }


        if (color == -1){

            if ((col - this.col) != 1){
                return false;
            }
            if (row == this.row){
                return Board.gameBoard[col][row] == 0;
            }
            else return (Math.abs(this.row - row) == 1) && (Board.gameBoard[col][row] < 0);
        }
        return false;
    }


}
