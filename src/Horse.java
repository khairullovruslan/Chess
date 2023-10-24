public class Horse extends BasicFigure{



    Horse(int color, int col, int row){
        super(color, col, row);

    }
    public  boolean checkMove(int col, int row){
        return (Math.abs(this.col - col) == 1 && Math.abs(this.row - row) == 2) | (Math.abs(this.col - col) == 2 && Math.abs(this.row - row) == 1);


    }

}
