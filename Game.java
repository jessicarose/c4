package connect4;

public class Game {	

	private Player Player1;
	private ComputerPlayer Player2;
	private Board Board;

	public Game(){
		
	this.Board = new Board();
	this.Player1 = new Player('o');
	this.Player2 = new ComputerPlayer('x');
	
	
	}
//will instantiate/call board
//should set number of players
	//must have 1 human player and 1-2 computer players
//

}
