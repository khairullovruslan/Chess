
public class Rook extends BasicFigure{




    Rook(int color, int col, int row){
        super(color, col, row);

    }
    public  boolean checkMove(int col, int row){

        if (col == this.col){
            if (row > this.row){
                System.out.println("row:" + row + " this.row : " + this.row);
                for(int i = this.row + 1;  i < row - 1;i++){
                    System.out.println(i);
                    if (Board.gameBoard[col-1][i] != 0){
                        return false;
                    }
                }

            }
            else {
                for(int i = row + 1;  i < this.row - 1;i++){
                    if (Board.gameBoard[col-1][i] != 0){
                        return false;
                    }
                }

            }


        }
        if (row == this.row){
            if (col > this.col){

                for(int i = col - 1;  i > this.col;i++){
                    if (Board.gameBoard[i][row] != 0){
                        return false;
                    }
                }
            }
            else {
                for(int i = this.col - 1;  i > col;i++){
                    if (Board.gameBoard[i][row] != 0){
                        return false;
                    }
                }
            }


        }

        if (Board.gameBoard[col][row] * this.color >= 0){
            return true;
        }
        return false;



    }


}
