import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board.printBoard();
        startGame();
    }

    public static void startGame(){
        System.out.println("Игра началась!");
        System.out.println("Первый ход у белых | ");
        System.out.println("Ваш ход должен введен корректно :1-1-1-2");
        int step = 1;  // 1 - white | -1 - black
        Scanner scanner = new Scanner(System.in);

        while (true){
                if (step > 0){
                    System.out.println("Ход белых:");
                }
                else{
                    System.out.println("Ход черных");
                }


                String line = scanner.nextLine();
                String cheking = checkStep(line, step)[0];
                String error = checkStep(line, step)[1];
                while (cheking.equals("false")){
                    System.out.println("Ошибка: " +error);
                    Board.printBoard();
                    line = scanner.nextLine();
                    cheking = checkStep(line, step)[0];
                    error = checkStep(line, step)[1];


                }
                String[] parametrs = line.split("-");
                int pos1 = Integer.parseInt(parametrs[0]) - 1, pos2 =Integer.parseInt(parametrs[1]) - 1,
                        pos3 = Integer.parseInt(parametrs[2]) - 1, pos4 = Integer.parseInt(parametrs[3]) - 1;
                int type_f =  Board.gameBoard[pos1][pos2];
                if (Board.gameBoard[pos3][pos4] == 6 * step){
                    if (step == 1){
                        System.out.println("Выиграла команда белых");
                        break;}
                    System.out.println("Выиграла команда черных");
                    break;
                }
                moveFigure(type_f, step, pos1, pos2, pos3, pos4);
                Board.printBoard();
                step *= -1;


            }


        }


    public static  String[] checkStep(String step, int color){
        String[] new_line = step.split("-");
        if (new_line.length != 4){
            return new String[]{"false", "Неправильный формат ввода.\nУбедидесь, что вы ввели 4 позиции через '-'.\nПример: 1-1-2-2"};
        }
        for (String s : new_line) {
            if (!(isNumeric(s))) {
                return new String[]{"false", "Неправильный формат ввода.\nУбедидесь, что вы ввели 4 числовых значения через '-'. \nПример: 1-1-2-2"};
            }
        }
        int pos1 = Integer.parseInt(new_line[0]) - 1, pos2 =Integer.parseInt(new_line[1]) - 1,
                pos3 = Integer.parseInt(new_line[2]) - 1, pos4 = Integer.parseInt(new_line[3]) - 1;
        if ((pos1 <0 || pos1 > 7) ||  (pos2 <0 || pos2 > 7) ||(pos3 <0 || pos3 > 7) ||(pos4 <0 || pos4 > 7)){
            return new String[]{"false", "Некорректный ход. \nВы вышли за рамки доски"};
        }
        if  (color * Board.gameBoard[pos1][pos2] >= 0){
            return new String[]{"false", "Некорректный ход. \nВы попытались сходить с фигурой противника"};


        }
        int type_f = Board.gameBoard[pos1][pos2];
        if  (type_f == 1 || type_f == -1) {

            Pawn pawn = new Pawn(color, pos1, pos2);
            if (pawn.checkMove(pos3, pos4)){
                return new String[]{"true", "1"};
            }
            return new String[]{"false", "Некорректный ход фигру.\nУбедитесь, что ваша фигура может так ходить\n" +
                    "Пешка ходит по вертикали на 1 клетку,\n" +
                    "Рубит по диагонали на 1 клетку"};
        }
        else if  (type_f == 2 || type_f == -2) {
            Horse horse = new Horse(color, pos1, pos2);
            if (horse.checkMove(pos3, pos4)){
                return new String[]{"true", "1"};
            }
            return new String[]{"false", "Некорректный ход фигру. \nУбедитесь, что ваша фигура может так ходить \n" +
                    "Конь ходит и рубит траекторией,похожей на русскую букву «Г»"};


        }
        else if  (type_f == 3 || type_f == -3) {
            Elephant elephant = new Elephant(color, pos1, pos2);
            if (elephant.checkMove(pos3, pos4)){
                return new String[]{"true", "1"};
            }
            return new String[]{"false", "Некорректный ход фигру. \nУбедитесь, что ваша фигура может так ходить \n" +
                    "Слон ходит на любое число полей по диагонали, при условии, что на его пути нет фигур."};


        }
        else if  (type_f == 4 || type_f == -4) {
            Rook rook = new Rook(color, pos1, pos2);
            if (rook.checkMove(pos3, pos4)){
                return new String[]{"true", "1"};
            }
            return new String[]{"false", "Некорректный ход фигру. \nУбедитесь, что ваша фигура может так ходить \n" +
                    "Ладья ходит и рубит на любое число полей по горизонтали или по вертикали при условии, что на её пути нет фигур"};


        }
        else if  (type_f == 5 || type_f == -5) {
            Queen queen = new Queen(color, pos1, pos2);
            if (queen.checkMove(pos3, pos4)){
                return new String[]{"true", "1"};
            }
            return new String[]{"false", "Некорректный ход фигру. \nУбедитесь, что ваша фигура может так ходить \n" +
                    "Ферзь ходит на любое число полей по вертикали, горизонтали или диагонали — соединяет в себе ходы ладьи и слона"};


        }
        else if  (type_f == 6 || type_f == -6) {
            King king = new King(color, pos1, pos2);
            if (king.checkMove(pos3, pos4)){
                return new String[]{"true", "1"};
            }
            return new String[]{"false", "Некорректный ход фигру. \nУбедитесь, что ваша фигура может так ходить \n" +
                    "Король может перемещаться в любом направлении, но только на 1 поле."};


        }
        return new String[]{"false", "Непонятная ошибка"};

    }
    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void moveFigure(int type_f, int color, int pos1, int pos2, int pos3, int pos4){
        if  (type_f == 1 || type_f == -1) {
            Pawn pawn = new Pawn(color, pos1, pos2);
            pawn.move(type_f, pos3, pos4);
        }
         else if  (type_f == 2 || type_f == -2) {
             Horse horse = new Horse(color, pos1, pos2);
             horse.move(type_f, pos3, pos4);


        }
        else if  (type_f == 3 || type_f == -3) {
            Elephant elephant = new Elephant(color, pos1, pos2);
            elephant.move(type_f, pos3, pos4);

        }
        else if  (type_f == 4 || type_f == -4) {
            System.out.println("rook moving");
            Rook rook = new Rook(color, pos1, pos2);
            rook.move(type_f, pos3, pos4);

        }
        else if  (type_f == 5 || type_f == -5) {
            System.out.println("queen moving");
            Queen queen = new Queen(color, pos1, pos2);
            queen.move(type_f, pos3, pos4);

        }
        else if  (type_f == 6 || type_f == -6) {
            King king = new King(color, pos1, pos2);
            king.move(type_f, pos3, pos4);

        }






    }
}