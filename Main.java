package connect4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IOException { 
		Game Game = new Game();
	
		Game.playerTurn();
         /*
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Press 2 for a 2 player game. 3 for a 3 player game.");
		 
		int userInput = Integer.parseInt(reader.readLine());
		
		//take user input
		if (userInput == 2) {
			System.out.println("2 player game");
			//1 human, 1 computer
			//run game.java here
		}
		else if (userInput == 3){
			System.out.println("3 player game");
			//1 human, 2 computer
			//run game2.java here
		}
		else {
			System.out.println("Please try again, selecting 2 or 3");
			
		} */
		
		//if 2, run game
		
		//if 3 run game2
		//if anything else, ask again

	}



	//draw board: done
	//Instantiate players
	//--
	//place move
	//check move is possible
	//check space is empty
	//place token
	//check move for win condition
	//check board for full fullness
	//--
	//next player
	//repeat in --
	//

	
	
}
