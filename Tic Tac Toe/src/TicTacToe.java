//Program that mimics Tic Tac Toe game
import java.util.*;

public class TicTacToe {
    static String[] gameBoard;
    static String playerTurn;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        gameBoard = new String[9];
        playerTurn = "X";
        String winner = "";

        for (int a = 0; a < 9; a++) {
            gameBoard[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner.equals("")) {
            int checkInput = in.nextInt();

            while (!(checkInput > 0 && checkInput <= 9)) {
                System.out.println("Invalid input, try again:");
                checkInput = in.nextInt();
            }

            if (gameBoard[checkInput - 1].equals(String.valueOf(checkInput))) {
                gameBoard[checkInput - 1] = playerTurn;

                if (playerTurn.equals("X")) {
                    playerTurn = "O";
                }else {
                    playerTurn = "X";
                }

                printBoard();
                winner = checkWinningPlayer();
            }
            else {
                System.out.println("Slot already taken; re-enter slot number:");
            }
        }

        //prints Congratulations or draw messages
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        }else {
            System.out.printf("Congratulations! %s won! Thanks for playing!", winner);
        }
    }

    //Checks if any player wins
    static String checkWinningPlayer(){
        for (int i = 0; i < gameBoard.length; i++) {
            String winning = switch (i) {
                case 0 -> gameBoard[0] + gameBoard[1] + gameBoard[2];
                case 1 -> gameBoard[3] + gameBoard[4] + gameBoard[5];
                case 2 -> gameBoard[6] + gameBoard[7] + gameBoard[8];
                case 3 -> gameBoard[0] + gameBoard[3] + gameBoard[6];
                case 4 -> gameBoard[1] + gameBoard[4] + gameBoard[7];
                case 5 -> gameBoard[2] + gameBoard[5] + gameBoard[8];
                case 6 -> gameBoard[0] + gameBoard[4] + gameBoard[8];
                case 7 -> gameBoard[2] + gameBoard[4] + gameBoard[6];
                default -> "";
            };

            if (winning.equals("XXX")) {
                return "X";
            }else if (winning.equals("OOO")) {
                return "O";
            }
        }

        //Checks if it's a draw
        for (int i = 0; i < gameBoard.length + 1; i++) {
            if (Arrays.asList(gameBoard).contains(String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                return "draw";
            }
        }

        // prompts player to choose a slot to enter X or O
        System.out.println(playerTurn + "'s turn, please enter a slot number to place " + playerTurn + " in:");
        return "";
    }

    //prints the board
    /* |-----------|
       | 1 | 2 | 3 |
       |-----------|
       | 4 | 5 | 6 |
       |-----------|
       | 7 | 8 | 9 |
       |-----------|*/
    static void printBoard() {
        System.out.println("|-----------|");
        System.out.println("| " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " |");
        System.out.println("|-----------|");
    }
}
