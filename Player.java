package connect4;

import java.io.IOException;

abstract class Player {
	public char gameToken;
	//gameToken is the piece put down by the player on the board
	public Player(char gameToken) {
		this.gameToken = gameToken;
	}
	abstract void getMove() throws IOException;
		//allows user to select move
		//subclasses contain move logic for human and computer players
		
	
}
