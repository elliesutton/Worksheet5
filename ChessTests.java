import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class ChessTests {
	
	String[][] chessBoard;
	Chess chessGame;
	
	@Before
	public void setUp(){
		chessBoard = new String[8][8];
		chessGame = new Chess(chessBoard);
	}
	
	

	@Test
	public void test1() {
		String expected1 = "KNIGHT";
		String expected2 = "knight";
		
		assertEquals(expected1, chessBoard[7][1]);
		assertEquals(expected2, chessBoard[0][1]);
		
	}
	
	@Test
	public void test2() {
		String expected1 = " ";
		String expected2 = "PAWN";
		
		assertEquals(expected1, chessBoard[2][3]);
		assertEquals(expected2, chessBoard[6][6]);
		
	}
	
	@Test
	public void test3() {
		chessGame.movePiece('a', '1', 'a', '4');
		String expected1 = " ";
		String expected2 = "ROOK";
		
		assertEquals(expected1, chessBoard[7][0]);
		assertEquals(expected2, chessBoard[4][0]);
		
	}
	
	@Test
	public void test4() {
		String expected1 = "pawn";
		String expected2 = "bishop";
		
		assertEquals(expected1, chessBoard[1][2]);
		chessGame.movePiece('c', '8', 'c', '7');

		assertEquals(expected2, chessBoard[1][2]);
	}
	
	@Test
	public void test5() {
		String expected1 = "queen";
		String expected2 = "PAWN";
		
		assertEquals(expected1, chessBoard[0][3]);
		chessGame.movePiece('d', '2', 'd', '8');
		assertEquals(expected2, chessBoard[0][3]);
	}
	
	@Test
	public void test6() {
		String expected1 = "KING";
		String expected2 = " ";
		
		assertEquals(expected1, chessBoard[7][4]);
		chessGame.movePiece('e', '1', 'e', '3');
		assertEquals(expected2, chessBoard[7][4]);
	}

}
