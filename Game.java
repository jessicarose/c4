package connect4;



public class Game {	
//run this version of the game for 1 human player against 1 computer player
	private HumanPlayer Player1;
	private ComputerPlayer Player2;
	private Board Board;
	private Object[] Players;

	public Game(){
		
	this.Board = new Board();
	this.Player1 = new HumanPlayer('o');
	this.Player2 = new ComputerPlayer('x');
	//change to a letter if not a valid char
	this.Players[0] = Player1;
	this.Players[1] = Player2;
	
	System.out.println("Welcome to Connect 4");
	System.out.println("There are 2 players red and yellow");
	System.out.println("You are o, Player 2 is x");
	System.out.println("To play the game type in the number of the column you want to drop you counter in");
	System.out.println("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally");
	System.out.println("");

	boolean win = false;
	
	}
	
	
public void playerTurn(){
	//have a loop going for turns between players
	//for each player, run getMove method
	//write a placeMove method, which takes validated move from either player class and places on board
	//checks for win conditions around placed move horizontally
	//checks for win conditions around placed move vertically
	//checks for win conditions around placed move diagonally
	//if there's no win, move to next turn
}
//

}
