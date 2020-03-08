package connect4;
import java.util.Scanner;



class HumanPlayer extends Player{

	public HumanPlayer(char gameToken) {
		super(gameToken);		

		}
	@Override
	int getMove() {
		//Stuck trying to make a scanner that takes an input and converts that to an int to pass up as the move, does Player class need a parameter that holds the value of the move? How the fuck do scanners work?
		Scanner inputMove = new Scanner(System.in);
	    System.out.println("Pick your row, 1-7");   
	    
	    String input = inputMove.nextLine();  // Read user input
	    return(Integer.parseInt(input));

		    
 
 
		    //need to grab this input
		    //need to save this input to a variable
		    //validation for acceptable move needs to sit here, will be hardcoded for computer players. check that input is a number 1-7, then check that chosen column isn't full
		    //getMove function could return this as a validated int that's had 1 subtracted from it, to match array index
		    //pass validated -1 int to game.java?
	
		
	}
	}

