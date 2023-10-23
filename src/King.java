public class King extends BasicFigure{




    King(int color, int col, int row){
        super(color, col, row);

    }
    public  boolean checkMove(int col, int row){
        if (Math.abs(this.col  - col) <= 1 && Math.abs(this.row  - row) <= 1){
            return true;
        }
        return false;



    }

}
