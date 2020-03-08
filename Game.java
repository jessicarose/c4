package connect4;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private Board Board;
	private Player[] Players;

	
	int N;
	public Game() {
		this.Board = new Board();
		this.Board.defineBoard();
		this.Board.drawBoard();
	}
	
	public void setN (int N) {
		this.N = N;
	}

	public void setPlayers(int numberOfPlayers) {
		this.Players = new Player[numberOfPlayers];
		if (numberOfPlayers == 2) {
			this.Players[0] = new HumanPlayer('1');
			this.Players[1] = new ComputerPlayer('2');
			System.out.println("You're playing against 1 computer player");
		} else if (numberOfPlayers == 3) {
			this.Players[0] = new HumanPlayer('1');
			this.Players[1] = new ComputerPlayer('2');
			this.Players[2] = new ComputerPlayer('3');
			System.out.println("You're playing against 2 computer players");
		} else {
			System.out.println("You need to pick 2 or 3");
		}
	}

	public void playerTurn() throws IOException {
		boolean win = false;
		int currentPlayerTurnNumber = 0;
		while (!win) {
			Board.drawBoard();
			int columnNumber = Players[currentPlayerTurnNumber].getMove();
			boolean isValid = validateMove(columnNumber);
			if (isValid) {

				int rowNumber = placeMove(columnNumber, Players[currentPlayerTurnNumber].gameToken);
				// ToDo change N to user input, hardcoded to 4 below
				if (checkWin(Players[currentPlayerTurnNumber].gameToken, columnNumber, rowNumber, N)) {
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

			} else {
				System.out.print("Column full, try again");
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
			} else {
				// if matching tokens aren't found back to back, reset this counter to 0
				matchingTokens = 0;
			}

		}

		return false;
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
		int column = columnNumber - 1;
		int rowCount = Board.boardSpaces.length;
		int columnCount = Board.boardSpaces[0].length;

		// bottom left d1
		while (row < rowCount && column >= 0) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row++;
			column--;
		}
		row = rowNumber - 1;
		column = columnNumber;
		// top right: d1
		while (row >= 0 && column < columnCount) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row--;
			column++;

		}
		int matchingTokens = 0;
		for (int i = 0; i < diagonalPoints.size(); i++) {
			point pt = diagonalPoints.get(i);
			if (Board.boardSpaces[pt.row][pt.column] == gameToken) {
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

	// this checks for wins along top right to bottom left axes
	boolean checkDiagonal2(char gameToken, int rowNumber, int columnNumber, int N) {
		List<point> diagonalPoints = new ArrayList<point>(); // this list represents all points along the diagonal
		int row = rowNumber;
		int column = columnNumber - 1;
		int rowCount = Board.boardSpaces.length;
		int columnCount = Board.boardSpaces[0].length;

		// bottom right d2
		while (row < rowCount && column < columnCount) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row++;
			column++;
		}
		row = rowNumber - 1;
		column = columnNumber - 2;
		// top left: d2
		while (row >= 0 && column >= 0) {
			point pt = new point();
			pt.row = row;
			pt.column = column;
			diagonalPoints.add(pt);
			row--;
			column--;

		}
		int matchingTokens = 0;
		for (int i = 0; i < diagonalPoints.size(); i++) {
			point pt = diagonalPoints.get(i);
			if (Board.boardSpaces[pt.row][pt.column] == gameToken) {
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

//this method combines all checks for different types of win conditions defined earlier
	boolean checkWin(char gameToken, int columnNumber, int rowNumber, int N) {
		if (checkVertical(gameToken, columnNumber, rowNumber, N) == true) {
			return true;
		}

		if (checkHorizontal(gameToken, rowNumber, N)) {
			return true;
		}

		if (checkDiagonal1(gameToken, rowNumber, columnNumber, N) == true) {
			return true;
		}

		if (checkDiagonal2(gameToken, rowNumber, columnNumber, N) == true) {
			return true;
		}
		return false;
	}

}
