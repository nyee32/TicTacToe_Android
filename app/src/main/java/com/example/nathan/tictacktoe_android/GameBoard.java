package com.example.nathan.tictacktoe_android;

/**
 * back end code for the game
 * Created by Nathan on 11/5/2015.
 */
public class GameBoard {
    private int[][] board = new int[3][3];
    private int count;

    public GameBoard() {
    }


    public void addMark(int positionRVal, playerTurn type) {
        switch (positionRVal) {
            case R.id.topLeft:
                board[0][0] = type.ordinal() + 1;
                System.out.println("topLeft");
                break;
            case R.id.topMiddle:
                board[0][1] = type.ordinal() + 1;
                break;
            case R.id.topRight:
                board[0][2] = type.ordinal() + 1;
                break;
            case R.id.middleLeft:
                board[1][0] = type.ordinal() + 1;
                break;
            case R.id.middle:
                board[1][1] = type.ordinal() + 1;
                break;
            case R.id.middleRight:
                board[1][2] = type.ordinal() + 1;
                break;
            case R.id.bottomLeft:
                board[2][0] = type.ordinal() + 1;
                break;
            case R.id.bottomMiddle:
                board[2][1] = type.ordinal() + 1;
                break;
            case R.id.bottomRight:
                board[2][2] = type.ordinal() + 1;
                break;
            default:
                System.out.println("invalid");
        }
    }

    public playerTurn checkForWin() {
        playerTurn winner;

        winner = checkWinDiag();
        if (winner != null) {
            if (winner == playerTurn.turnO) {
                return playerTurn.turnO;
            } else {
                return playerTurn.turnX;
            }
        }

        winner = checkWinRow();
        if (winner != null) {
            if (winner == playerTurn.turnO) {
                return playerTurn.turnO;
            } else {
                return playerTurn.turnX;
            }
        }

        winner = checkWinCol();
        if (winner != null) {
            if (winner == playerTurn.turnO) {
                return playerTurn.turnO;
            } else {
                return playerTurn.turnX;
            }
        }

        return null;
    }

    /**
     * returns true if there is a win in the corner position
     *
     * @param start
     * @return
     */
    private playerTurn checkWinDiag() {
        int X = 0;
        int O = 0;
        int j = 2;
        boolean noWin = true;

        System.out.println("checking Diag");

        for (int i = 0; i < 3; i++) {
            if (board[i][i] == 1) {
                X++;
            } else if (board[i][i] == 2) {
                O++;
            }
        }

        if (X == 3 || O == 3) {
            if (X == 3) {
                return playerTurn.turnX;
            } else if (O == 3) {
                return playerTurn.turnO;
            }
        }

        X = 0;
        O = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][j - i] == 1) {
                X++;
            } else if (board[i][j - i] == 2) {
                O++;
            }
        }

        if (X == 3 || O == 3) {
            if (X == 3) {
                return playerTurn.turnX;
            } else if (O == 3) {
                return playerTurn.turnO;
            }
        }

        return null;
    }

    private playerTurn checkWinRow() {
        int X = 0;
        int O = 0;
        System.out.println("Cehcking Column");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 1) {
                    System.out.println("Found X");
                    X++;
                } else if (board[i][j] == 2) {
                    System.out.println("Found O");
                    O++;
                }
            }

            System.out.println("O = " + O);

            if (X == 3) {
                return playerTurn.turnX;
            } else if (O == 3) {
                System.out.println("HERE");
                return playerTurn.turnO;
            }

            X = 0;
            O = 0;

        }

        return null;
    }

    private playerTurn checkWinCol() {
        int X = 0;
        int O = 0;
        System.out.println("Cehcking Column");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 1) {
                    System.out.println("Found X");
                    X++;
                } else if (board[j][i] == 2) {
                    System.out.println("Found O");
                    O++;
                }
            }

            System.out.println("O = " + O);

            if (X == 3) {
                return playerTurn.turnX;
            } else if (O == 3) {
                System.out.println("HERE");
                return playerTurn.turnO;
            }

            X = 0;
            O = 0;

        }

        return null;
    }

    public void printBoard() {
        System.out.print("\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
