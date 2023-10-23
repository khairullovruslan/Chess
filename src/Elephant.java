public class Elephant extends  BasicFigure {




    Elephant(int color, int col, int row){
        super(color, col, row);
    }
    public  boolean checkMove(int col, int row){
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
