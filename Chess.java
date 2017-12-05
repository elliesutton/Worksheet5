import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Chess is a class that allows a user to move pieces around a chess board
 * by inputting a command such as 'a2a4' to move a piece from a2 to a4.
 * It permanently removes any piece that is taken. 
 * 
 * @author Ellie Sutton
 *
 */
public class Chess {
	
	public static String[][] chessBoard = new String[8][8];
	public static final Pattern validEntry = Pattern.compile("[a-h][1-8][a-h][1-8]|q");
	
	/**
	 * Chess is a constructor that creates a chess board
	 * of type String[][].
	 * @param chessBoard The chess board
	 */
	public Chess(String[][] chessBoard){
		this.initialBoard(chessBoard);
	}
	
	/**
	 * initialBoard initialises the chess board, placing all pieces
	 * in their starting positions
	 * @param chessBoard The chess board
	 */
	public void initialBoard(String[][] chessBoard){

       		 for (int i = 2; i < 6; i++) {
            		for (int j = 0; j < 8; j++) {
               			 chessBoard[i][j] = " ";
            		}
        	}
        
		chessBoard[0][0] = "rook";
		chessBoard[0][1] = "knight";
		chessBoard[0][2] = "bishop";
		chessBoard[0][3] = "queen";
		chessBoard[0][4] = "king";
		chessBoard[0][5] = "bishop";
		chessBoard[0][6] = "knight";
		chessBoard[0][7] = "rook";
		chessBoard[7][0] = "ROOK";
		chessBoard[7][1] = "KNIGHT";
		chessBoard[7][2] = "BISHOP";
		chessBoard[7][3] = "QUEEN";
		chessBoard[7][4] = "KING";
		chessBoard[7][5] = "BISHOP";
		chessBoard[7][6] = "KNIGHT";
		chessBoard[7][7] = "ROOK";
	
		for (int i=0; i<8; i++)
			chessBoard[1][i] = "pawn";

		for (int j=0; j<8; j++)
			chessBoard[6][j] = "PAWN";
		
		Chess.chessBoard = chessBoard;
		
	}
	
	/**
	 * movePiece moves a piece from one position on the board to another and
	 * removes a piece when another is moved on top of it.
	 * @param a The initial column 
	 * @param b The initial row
	 * @param c The end column
	 * @param d The end row
	 */
	public void movePiece(char a, char b, char c, char d){	
		int initialCol = (int) a - 'a' ;
		int initialRow = (int) b - 48;
		int endCol = (int) c - 'a' ;
		int endRow = (int) d - 48;
		
		System.out.println("Your move was: " + a + b + " to " + c + d + "\n");
		
		//if trying to move from an empty space
		if (chessBoard[8-initialRow][initialCol] == " "){
			System.out.println("No piece at start position. Please try again.");
		}
		//if end position = current position
		else if (initialCol == endCol && initialRow == endRow){
			System.out.println("No movement.");
		}
		else {
			chessBoard[8 - endRow][endCol] = chessBoard[8 - initialRow][initialCol];
			chessBoard[8-initialRow][initialCol] = " ";
		}
		

	} 
	
	/**
	 * chessGame prompts the user to input their move and throws an exception if the
	 * move is not of correct form. If the user enters q then they quit the game.
	 */
	public void chessGame(){
		boolean continueGame = true;
		System.out.println("Please enter a move, eg a2a4.");
		System.out.println("Enter q to quit game.\n");
		System.out.println(toString());
		Scanner scanner = new Scanner(System.in);
		
		do {
			try {
				String command = scanner.next(validEntry);
				if (command.charAt(0) == 'q') {
					continueGame = false;
					scanner.close();
					break;
				}
				char initialCol = command.charAt(0);
				char initialRow = command.charAt(1);
				char endCol = command.charAt(2);
				char endRow = command.charAt(3);
				movePiece(initialCol, initialRow, endCol, endRow);
				System.out.println(toString());
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid entry. Please try again.");
				scanner = new Scanner(System.in);
			}
	
		} while (continueGame == true);
		
	}

	
			
	/**
	 * toString method
	 * @return The chess board in its current state
	 */
	public String toString() {
		String string = "     a        b        c        d        e        f        g         h";
		    for (int i = 0; i < 8; i++) {
		    	string += "\n  -----------------------------------------------------------------------\n" + (8-i) + "|";
		    	for (int j = 0; j < 8; j++) {
            	string += String.format("%9s",chessBoard[i][j] + " | ");
		    	}
		    }
            string += "\n  -----------------------------------------------------------------------";
		return string;
	} 
	
	
	public static void main(String[] args){
		String[][] chessBoard = new String[8][8];
		Chess chessGame = new Chess(chessBoard);
		chessGame.chessGame();
	}


}
