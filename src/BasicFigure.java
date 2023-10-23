public class BasicFigure {

    public int color,   row, col;


    BasicFigure(int color, int col, int row){
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public void move(int type, int col, int row){
        Board.gameBoard[col][row] = Math.abs(type) * color * -1;
        Board.gameBoard[this.col][this.row] = 0;




    }
}
