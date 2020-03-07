package connect4;



public class Game2 {	

	private HumanPlayer Player1;
	private ComputerPlayer Player2;
	//uncomment player3 when ready
	//	private ComputerPlayer Player3;
	private Board Board;
	private Object[] Players;

	public Game2(){
		
	this.Board = new Board();
	this.Player1 = new HumanPlayer('o');
	this.Player2 = new ComputerPlayer('x');
	//change to a letter if not a valid char
	//this.Player3 = new ComputerPlayer('*');
	this.Players[0] = Player1;
	this.Players[1] = Player2;
	//this.Players[2] = Player3;
	
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
