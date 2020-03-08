package connect4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
//run this version of the game for 1 human player against 1 computer player
	private HumanPlayer Player1;
	private HumanPlayer Player2;
	// private ComputerPlayer Player3;
	private Board Board;
	private Player[] Players;

	public Game() {
		// change this 2 below to variable holding no of players
		this.Players = new Player[2];
		this.Board = new Board();
		this.Board.defineBoard();
		this.Board.drawBoard();

		this.Player1 = new HumanPlayer('1');
		// this.Player2 = new ComputerPlayer('x');
		// this.Player3 = new ComputerPlayer('u');
		this.Player2 = new HumanPlayer('2');

		this.Players[0] = Player1;
		this.Players[1] = Player2;

		//

		System.out.println("Welcome to ConnectN");
		// change to connectN after this works
		// write if loop printing out the 2 or 3 player game details
		System.out.println("There are 2 players 1 and 2");
		System.out.println("You are 1, Player 2 is 2");
		System.out.println("To play the game type in the number of the column you want to drop you counter in");
		System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
		System.out.println("");

	}

	public void playerTurn() throws IOException {
		// have a loop going for turns between players
		// for each player, run getMove method

		// write a checkWin method that:
		// checks for win conditions around placed move horizontally
		// checks for win conditions around placed move vertically
		// checks for win conditions around placed move diagonally
		// if there's no win, move to next player, restarting the playerTurn method
		// if it wins, display win message and end
		boolean win = false;
		int currentPlayerTurnNumber = 0;
		while (!win) {
			int columnNumber = Players[currentPlayerTurnNumber].getMove();
			boolean isValid = validateMove(columnNumber);
			if (isValid) {

				int rowNumber = placeMove(columnNumber, Players[currentPlayerTurnNumber].gameToken);
				// ToDo change N to user input, hardcoded to 4 below
				if (checkWin(Players[currentPlayerTurnNumber].gameToken, columnNumber, rowNumber, 4)) {
					win = true;
					System.out.println("Great job, " + Players[currentPlayerTurnNumber].gameToken);
					break;
				}
				// move to next player's turn
				currentPlayerTurnNumber = currentPlayerTurnNumber + 1;
				// loop back to the first player if it's their turn
				if (currentPlayerTurnNumber == Players.length) {
					currentPlayerTurnNumber = 0;
				}

				Board.drawBoard();

				// check the array length
				// if it's not at the max, increment by 1
				// if at max set to zero

			} else {
				// skip turn
			}

		}
	}

	boolean validateMove(int columnNumber) {
		// checks the top of game board in designated column row to see if it (and thus
		// the row) is full
		if (this.Board.boardSpaces[0][columnNumber - 1] == '.') {
			return true;
		} else {
			// move is not valid
			return false;
		}
	}

	int placeMove(int columnNumber, char gameToken) {
		int rowCount = Board.boardSpaces.length;
		int rowToReturn = 0;
		for (int i = rowCount - 1; i >= 0; i--) {
			if (this.Board.boardSpaces[i][columnNumber - 1] == '.') {
				this.Board.boardSpaces[i][columnNumber - 1] = gameToken;
				rowToReturn = i;
				break;
			}

		}
		return rowToReturn;

		// loop up from bottom of the array
		// find the first blank space in the column
		// set that index value to playerToken
	}

	boolean checkHorizontal(char gameToken, int rowNumber, int N) {
		int matchingTokens = 0;
		for (int i = 0; i < Board.boardSpaces[0].length; i++) {
			// check the row you've just made a move in to see if there are consecutive
			// matching tokens
			if (Board.boardSpaces[rowNumber][i] == gameToken) {
				// increment matching Tokens counter as more are found in a row
				matchingTokens++;
				if (matchingTokens == N) {
					return true;
				}
				System.out.println("Matching tokens are " + matchingTokens);
			} else {
				// if matching tokens aren't found back to back, reset this counter to 0
				matchingTokens = 0;
			}

		}

		return false;

		// if you have enough matching tokens in a row, return true to win

		// local var matchingTokens
		// loop over the row designated
		// continue to iterate while you see matching tokens and matchingToken +1;
		// stop if you don't continue to see matching tokens : flase
		// stop if you see N number of tokens in a row and return true
		// if matchingTokens == n; return true
		// if you reach the end of the row without matching N tokens, return false
	}

	boolean checkVertical(char gameToken, int columnNumber, int rowNumber, int N) {
		int matchingTokens = 0;
		// start at the row space where a token has been placed
		for (int i = rowNumber; i < Board.boardSpaces.length; i++) {
			// check the row you've just made a move in to see if there are consecutive
			// matching tokens
			if (Board.boardSpaces[i][columnNumber - 1] == gameToken) {
				// increment matching Tokens counter as more are found in a row
				matchingTokens++;
				if (matchingTokens == N) {
					return true;
				}
			} else {
				// if matching tokens aren't found back to back, reset this counter to 0
				matchingTokens = 0;
			}

		}

		return false;

	}
//this checks for wins along bottom left to top right axes
	boolean checkDiagonal1(char gameToken, int rowNumber, int columnNumber, int N) {
		List<point> diagonalPoints = new ArrayList<point>(); // this list represents all points along the diagonal
		int row = rowNumber;
		int column = columnNumber -1;
		int rowCount = Board.boardSpaces.length;
		int columnCount = Board.boardSpaces[0].length;
		
		//bottom left d1
		while (row<rowCount && column>=0) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row++;
			column--;
		}
		row = rowNumber -1 ;
		column = columnNumber;
		//top right: d1
		while(row>=0 && column< columnCount) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row--;
			column ++;
			
		}
		int matchingTokens = 0;
		for(int i = 0; i < diagonalPoints.size();i ++) {
			point pt = diagonalPoints.get(i);
			if (Board.boardSpaces[pt.row][pt.column] == gameToken) {
				// increment matching Tokens counter as more are found in a row
				matchingTokens++;
				if (matchingTokens == N) {
					return true;
				}
				//System.out.println("Matching tokens are " + matchingTokens);
			} else {
				// if matching tokens aren't found back to back, reset this counter to 0
				matchingTokens = 0;
			}
			
		}

		return false;
		
	}
	//this checks for wins along top right to bottom left axes
	boolean checkDiagonal2(char gameToken, int rowNumber, int columnNumber, int N) {
		List<point> diagonalPoints = new ArrayList<point>(); // this list represents all points along the diagonal
		int row = rowNumber;
		int column = columnNumber -1;
		int rowCount = Board.boardSpaces.length;
		int columnCount = Board.boardSpaces[0].length;
		
		//bottom right d2
		while(row<rowCount && column<columnCount) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row++;
			column++;
		}
		row = rowNumber -1 ;
		column = columnNumber - 2;
		//top left: d2
		while(row>=0 && column>=0) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row--;
			column --;
			
		}
		int matchingTokens = 0;
		for(int i = 0; i < diagonalPoints.size();i ++) {
			point pt = diagonalPoints.get(i);
			if (Board.boardSpaces[pt.row][pt.column] == gameToken) {
				// increment matching Tokens counter as more are found in a row
				matchingTokens++;
				if (matchingTokens == N) {
					return true;
				}
				//System.out.println("Matching tokens are " + matchingTokens);
			} else {
				// if matching tokens aren't found back to back, reset this counter to 0
				matchingTokens = 0;
			}
			
		}

		return false;
		
	}

	boolean checkWin(char gameToken, int columnNumber, int rowNumber, int N) {
		if (checkVertical(gameToken, columnNumber, rowNumber, N) == true) {
			return true;
		}

		if (checkHorizontal(gameToken, rowNumber, N)) {
			return true;
		}
		
		if(checkDiagonal1(gameToken, rowNumber, columnNumber, N)== true){
			return true;
		}
		
		if(checkDiagonal2(gameToken, rowNumber, columnNumber, N)== true){
			return true;
		}
		return false;
	}

	
}
