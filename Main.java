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
		//select 2 or 3 player game
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


//Future ToDos:
//Extend to support rendering emoji in command line
//Extend to allow for variable human/computer player combos
	
	

