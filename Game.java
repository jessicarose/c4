package connect4;
import java.io.BufferedReader;



public class Game {	
//run this version of the game for 1 human player against 1 computer player
	private HumanPlayer Player1;
	private HumanPlayer Player2;
	//private ComputerPlayer Player3;
	private Board Board;
	private Player[] Players;

	public Game(){
	//change this 2 below to variable holding no of players
	this.Players = new Player[2];
	this.Board = new Board();
	this.Board.defineBoard();
	this.Board.drawBoard();
	
	this.Player1 = new HumanPlayer('1');
	//this.Player2 = new ComputerPlayer('x');
	//this.Player3 = new ComputerPlayer('u');
	this.Player2 = new HumanPlayer('2');
	
	this.Players[0] = Player1;
	this.Players[1] = Player2;
	
	//
	
	System.out.println("Welcome to ConnectN");
	//change to connectN after this works
	//write if loop printing out the 2 or 3 player game details
	System.out.println("There are 2 players 1 and 2");
	System.out.println("You are 1, Player 2 is 2");
	System.out.println("To play the game type in the number of the column you want to drop you counter in");
	System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
	System.out.println("");

	
	
	
	}
	
	
public void playerTurn(){
	//have a loop going for turns between players
	//for each player, run getMove method
	//validate the move if needed (human players)
	//write a placeMove method, which takes validated move from either player class and places on board
	//write a checkWin method that:
	//checks for win conditions around placed move horizontally
	//checks for win conditions around placed move vertically
	//checks for win conditions around placed move diagonally
	//if there's no win, move to next player, restarting the playerTurn method
	//if it wins, display win message and end
	boolean win = false;
	int currentPlayerTurnNumber = 0;
	while(!win) {
		int columnNumber = Players[currentPlayerTurnNumber].getMove();
		boolean isValid = validateMove(columnNumber) 
		if (isValid) {
			
			
			
		} else {
			//skip turn
		}

		
		
	}
}
 boolean validateMove(int columnNumber) {
	 //checks the top of game board in designated column row to see if it (and thus the row) is full
	 if (this.Board.boardSpaces[0][columnNumber-1]== '.') {
		 return true;
	 } else {
		 //move is not valid
		 return false;
	 }
 }
 
 void placeMove(int columnNumber, char gameToken) {
	 int rowCount = Board.boardSpaces[0].length;
	 for (int i = rowCount - 1; i > 0; i --) {
		 if (this.Board.boardSpaces[i][columnNumber-1]== '.') {
			 this.Board.boardSpaces[i][columnNumber-1] = gameToken;
			 break;
		 }
	 }
	 //loop up from bottom of the array
	 //find the first blank space in the column
	 //set that index value to playerToken
 }
	 
	 //take in the col number
	 //-1 
	 //iterate through column
	 //stop iterating and return true when it sees a .
	 //stop iterating and return false if there are no .
	 
 }

}
