public class Board {

    // 0 - пустота, 1 - пешка, 2 - конь, 3 - слон, 4 - Ладья,  5 - Ферзь, 6 - король


    static  int[][] gameBoard = {
                        {4,2,3,5,6,3,2,4},
                        {1,1,1,1,1,1,1,1},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {-1,-1,-1,-1,-1,-1,-1,-1},
                        {-4,-2,-3,-5,-6,-3,-2,-4}};

    public static   void printBoard() {
        System.out.println("  1   2   3   4   5   6   7   8 ");
        for (int i = 0; i < gameBoard.length; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < gameBoard[i].length; ++j) {
                switch (gameBoard[i][j]) {
                    case (1):
                        System.out.print('♙');
                        break;
                    case (-1):
                        System.out.print("♟");
                        break;
                    case (2):
                        System.out.print("♘");
                        break;
                    case (-2):
                        System.out.print("♞");
                        break;
                    case (3):
                        System.out.print("♗");
                        break;
                    case (-3):
                        System.out.print("♝");
                        break;
                    case (4):
                        System.out.print("♖");
                        break;
                    case (-4):
                        System.out.print("♜");
                        break;
                    case (5):
                        System.out.print("♕");
                        break;
                    case (-5):
                        System.out.print("♛");
                        break;
                    case (6):
                        System.out.print("♔");
                        break;
                    case (-6):
                        System.out.print("♚");
                        break;
                    default:
                        System.out.print(" ");
                        break;
                }

                System.out.print(" | ");
            }
            System.out.println();
        }
    }

}
