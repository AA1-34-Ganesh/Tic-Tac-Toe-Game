package com.inheritance;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    static char[][] board;

    public TicTacToe() {
        board = new char[3][3];
        initBoard();
    }

    void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    static void displayBoard() {
        System.out.println("------------");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("------------");
        }
    }

    static boolean placeMark(int row, int col, char mark) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            if (board[row][col] == ' ') {
                board[row][col] = mark;
                return true;
            }
        }
        System.out.println("Invalid position");
        return false;
    }

    static boolean checkCol() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }
        return false;
    }

    static boolean checkRow() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    static boolean checkDiag() {
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    abstract static class Player {
        String name;
        char mark;

        abstract void makeMove();

        abstract boolean isValid(int row, int col);
    }

    static class HumanPlayer extends Player {
        HumanPlayer(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }

        void makeMove() {
            Scanner scan = new Scanner(System.in);
            int row, col;
            do {
                System.out.println(name + "'s turn. Enter the row and column:");
                row = scan.nextInt();
                col = scan.nextInt();
            } while (!isValid(row, col));

            placeMark(row, col, mark);
        }

        boolean isValid(int row, int col) {
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (board[row][col] == ' ') {
                    return true;
                }
            }
            System.out.println("Invalid position");
            return false;
        }
    }

    static class ComputerPlayer extends Player {
        ComputerPlayer(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }

        void makeMove() {
            Random rand = new Random();
            int row, col;
            do {
                row = rand.nextInt(3);
                col = rand.nextInt(3);
            } while (!isValid(row, col));

            System.out.println(name + " placed " + mark + " at (" + row + ", " + col + ")");
            placeMark(row, col, mark);
        }

        boolean isValid(int row, int col) {
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                if (board[row][col] == ' ') {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        Player p1 = new HumanPlayer("Priya", 'X');
        Player p2 = new ComputerPlayer("Computer", 'O');

        Player currentPlayer = p1;
        boolean gameWon = false;

        while (!gameWon && !checkDraw()) {
            displayBoard();
            currentPlayer.makeMove();
            gameWon = checkRow() || checkCol() || checkDiag();

            if (gameWon) {
                displayBoard();
                System.out.println(currentPlayer.name + " wins!");
                break;
            }

            currentPlayer = (currentPlayer == p1) ? p2 : p1;

            if (checkDraw()) {
                displayBoard();
                System.out.println("The game is a draw!");
            }
        }
        
    }
}

























       
