package connect4;
import java.util.Scanner;



class HumanPlayer extends Player{

	public HumanPlayer(char gameToken) {
		super(gameToken);		

		}
	@Override
	int getMove() {
		//gets user input for next line
		Scanner inputMove = new Scanner(System.in);
	    System.out.println("Pick your row, 1-7");   
	    
	    String input = inputMove.nextLine();  // Read user input
	    //returns user input as move
	    return(Integer.parseInt(input));

		    
 

	
		
	}
	}

