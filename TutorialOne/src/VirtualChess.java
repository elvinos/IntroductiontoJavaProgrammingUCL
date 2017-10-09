import java.util.Scanner;

import static java.lang.StrictMath.abs;

public class VirtualChess {

    private static Scanner playerMoveScan;

	public static void main(String[] args) {
        Chessmen[][] chessboard = new Chessmen[8][8];
        // create new chess game
        newGame(chessboard);
        // print chess game
        printBoard(chessboard);
        playerMoveScan = new Scanner(System.in);
        String playerMove;
        String quit = "quit";
        int count = 1;
        // calculate which players turn
        String playerTurn;
        while (true) {
            if (count % 2 == 0) {
                playerTurn = "Black";
            } else {
                playerTurn = "White";
            }
            System.out.println(playerTurn + " your turn! Where do you want to move? (Or quit)");
            playerMove = playerMoveScan.nextLine();
            if (quit.equalsIgnoreCase(playerMove)) {
                break;
            }
            // move piece if valid
            boolean valid = move(chessboard, playerMove, playerTurn);
            if (valid) {
            // allow new player turn
                count++;
            } else {
                invalidWarning();
            }
            printBoard(chessboard);
        }
    }

// Populates chess board with pieces in the starting position
    public static void newGame(Chessmen[][] chessboard) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == 7) {
                    if (col == 0 || col == 7) {
                        chessboard[row][col] = Chessmen.WHITE_ROOK;
                    } else if (col == 1 || col == 6) {
                        chessboard[row][col] = Chessmen.WHITE_KNIGHT;
                    } else if (col == 2 || col == 5) {
                        chessboard[row][col] = Chessmen.WHITE_BISHOP;
                    } else if (col == 3) {
                        chessboard[row][col] = Chessmen.WHITE_QUEEN;
                    } else if (col == 4) {
                        chessboard[row][col] = Chessmen.WHITE_KING;
                    }
                } else if (row == 6) {
                    chessboard[row][col] = Chessmen.WHITE_PAWN;
                } else if (row == 1) {
                    chessboard[row][col] = Chessmen.BLACK_PAWN;
                } else if (row == 0) {
                    if (col == 0 || col == 7) {
                        chessboard[row][col] = Chessmen.BLACK_ROOK;
                    } else if (col == 1 || col == 6) {
                        chessboard[row][col] = Chessmen.BLACK_KNIGHT;
                    } else if (col == 2 || col == 5) {
                        chessboard[row][col] = Chessmen.BLACK_BISHOP;
                    } else if (col == 3) {
                        chessboard[row][col] = Chessmen.BLACK_QUEEN;
                    } else if (col == 4) {
                        chessboard[row][col] = Chessmen.BLACK_KING;
                    }
                } else {
                    chessboard[row][col] = Chessmen.EMPTY;
                }
            }
        }

    }

    /***
     * Prints Chess Board to the * @param chessboard
     */
    public static void printBoard(Chessmen[][] chessboard) {
        System.out.print("\ta \tb \tc \td \te \tf \tg \th \n");
        for (int row = 0; row < 8; row++) {
            int rowNum = 8 - row;
            System.out.print(rowNum + "\t");
            for (int col = 0; col < 8; col++) {
                System.out.print(chessboard[row][col].getUnicode());
            }
            System.out.print("\n");
        }
    }
// Method to control movement of pieces, calls rules() 
    public static boolean move(Chessmen[][] chessboard, String move, String playerTurn) {
// parse move string into components
        String[] components = move.split(" ");

// if you assume that move is "e1 e5" then
        char oPCchar = components[0].charAt(0);
        int oPC = oPCchar - 'a';
        char oPR = components[0].charAt(1);
        int oPR2 = -(Integer.parseInt(String.valueOf(oPR)) - 8);

        char nPCchar = components[1].charAt(0);
        int nPC = nPCchar - 'a';
        char nPR = components[1].charAt(1);
        int nPR2 = -(Integer.parseInt(String.valueOf(nPR)) - 8);

        Chessmen movedPiece = chessboard[oPR2][oPC];
        if (rules(chessboard, oPR2, oPC, nPR2, nPC, playerTurn)) {
            chessboard[oPR2][oPC] = Chessmen.EMPTY;
            chessboard[nPR2][nPC] = movedPiece;
            return true;
        } else {
            return false;
        }
    }

    /*
     Method to check whether move is valid
     */
    public static boolean rules(Chessmen[][] chessboard, int oPR, int oPC, int nPR, int nPC, String playerTurn)
            throws IndexOutOfBoundsException {
        try {
            // Prevents Pick Up of an Empty Piece
            if (chessboard[oPR][oPC] == Chessmen.EMPTY) {
                return false;
            }
            // Prevents placing the piece on same square
            if (chessboard[oPR][oPC].equals(chessboard[nPR][nPC])) {
                return false;
            }
            
            // Prevent players from placing on the same colour
            if (chessboard[oPR][oPC].getColour().equals(chessboard[nPR][nPC].getColour())) {
                return false;
            }

            // Prevent players from picking opposite colour
            if (!playerTurn.equals(chessboard[oPR][oPC].getColour())) {
                return false;
            }
            
            // Find the Amount of Squares the Piece moves
            int sCol = oPC - nPC;
            int sRow = oPR - nPR;
            int aMCol = abs(sCol);
            int aMRow = abs(sRow);

            // KING Rules
            if (chessboard[oPR][oPC] == Chessmen.BLACK_KING || chessboard[oPR][oPC] == Chessmen.WHITE_KING) {
                return (aMRow == 1 || aMRow == 0) && (aMCol == 1 || aMCol == 0);
            }
            // ROOK Rules
            if (chessboard[oPR][oPC] == Chessmen.BLACK_ROOK || chessboard[oPR][oPC] == Chessmen.WHITE_ROOK) {

                if ((aMCol > 0 && aMRow == 0) || (aMCol > 0 && aMRow == 0)) {
                    return pieceBlock(chessboard, sRow, sCol, oPR, oPC);
                } else return false;
            }
            //KNIGHT Rules
            if (chessboard[oPR][oPC] == Chessmen.BLACK_KNIGHT || chessboard[oPR][oPC] == Chessmen.WHITE_KNIGHT) {

                return (aMRow == 2 && aMCol == 1) || (aMCol <= 2 && aMRow == 1);
            }
            // QUEEN Rules
            if (chessboard[oPR][oPC] == Chessmen.BLACK_QUEEN || chessboard[oPR][oPC] == Chessmen.WHITE_QUEEN) {

                if ((aMRow > 0 && aMCol == 0) ||
                        (aMCol > 0 && aMRow == 0) ||
                        (aMRow > 0 && aMCol == aMRow) ||
                        (aMCol > 0 && aMRow == aMCol)) {

                    return pieceBlock(chessboard, sRow, sCol, oPR, oPC);

                } else {
                    return false;
                }
            }
            //BISHOP Rules
            if (chessboard[oPR][oPC] == Chessmen.BLACK_QUEEN || chessboard[oPR][oPC] == Chessmen.WHITE_QUEEN) {
                if ((aMRow > 0 && aMRow == aMCol ||
                        aMCol > 0 && aMCol == aMRow)) {
                    return pieceBlock(chessboard, sRow, sCol, oPR, oPC);
                }
            }
            //PAWN Rules
            if (chessboard[oPR][oPC] == Chessmen.BLACK_PAWN || chessboard[oPR][oPC] == Chessmen.WHITE_PAWN) {
                if (oPR == 6 && playerTurn.equals("White") && aMCol == 0) {
                    return (aMRow == 2 && chessboard[oPR - 1][oPC] == Chessmen.EMPTY || aMRow == 1);
                } else if (oPR == 1 && playerTurn.equals("Black") && aMCol == 0) {
                    return (aMRow == 2 && chessboard[oPR + 1][oPC] == Chessmen.EMPTY || aMRow == 1);
                } else if (aMRow == 1 && aMCol == 1 && chessboard[nPR][nPC] != (Chessmen.EMPTY)) {
                    return true;
                } else if (aMRow == 1 && aMCol < 1) {
                    return true;
                } else {
                    return false;
                }

            }
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
// Print Warning Message
    public static void invalidWarning() {
        System.out.println("Invalid move! Please try again...");
    }
    
// Blocks Moves Where Pieces Pass Through Each Other. Called in rules().
    private static Boolean pieceBlock(Chessmen[][] chessboard, int sRow , int sCol, int oPR, int oPC) {

        if (sCol > 0) {
            for (int i = 1; i < sCol; i++) {
                if (chessboard[oPR][oPC + i] != Chessmen.EMPTY) {
                    return false;
                }
            } return true;
        }

        if (sCol < 0) {
            for (int i = -1; i > sCol; i--) {
                if (chessboard[oPR][oPC + i] != Chessmen.EMPTY) {
                    return false;
                }
            } return true;
        }

        if (sRow > 0) {
            for (int i = 1; i < sRow; i++) {
                if (chessboard[oPR + i][oPC] != Chessmen.EMPTY) {
                    return false;
                }
            } return true;
        }

        if (sRow < 0) {
            for (int i = -1; i > sRow; i--) {
                if (chessboard[oPR + i][oPC] != Chessmen.EMPTY) {
                    return false;
                }
            } return true;
        }
        return false;
    }
}
