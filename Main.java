package connect4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws IllegalArgumentException, IOException { 
		Game Game = new Game();
	
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Welcome to ConnectN");
		
		//user prompt to select win condition
		System.out.println("To play the game type in the number of the column you want to drop you counter in");

		
		//sets N as win condition
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("How many tokens in a row to win? Select 3-6");
		int N = Integer.parseInt(reader.readLine());
		Game.setN(N);
		
		System.out.println("How many players would you like?");
		System.out.println("Press 2 for 2 player game, 3 for 3 player");
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
		int numberOfPlayers = Integer.parseInt(reader.readLine());
		Game.setPlayers(numberOfPlayers);
		System.out.println(
				"A player wins by connecting" + N + " counters in a row - vertically, horizontally or diagonally");
		System.out.println("");

		
		Game.playerTurn();


		}
		 
		


	}



	//draw board: done
	//Instantiate players: done
	//Set between 2-3 players
	//create computer player logic: test
	//--
	//place move: done for humans
	//check move is possible: done for humans
	//check space is empty: done for humans
	//place token: done
	//check move for win condition: done
	//check board for full fullness
	//--
	//next player
	//repeat in --
	//
	
	//ToDos:
	//set N to user input: here or on main? how to set as a global variable?
	//set 2 or 3 players to user input
	//restart a player's turn if invalid move entered
	//

	
	

