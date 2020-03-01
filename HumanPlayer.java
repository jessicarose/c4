package connect4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HumanPlayer extends Player{

	public HumanPlayer(char gameToken) {
		super(gameToken);		
		}
	@Override
	void getMove() throws IOException {
		System.out.println("Pick a column");
		 InputStreamReader r=new InputStreamReader(System.in);    
		    BufferedReader br=new BufferedReader(r);            
		    System.out.println("Pick your row, 1-7");    
		    String name=br.readLine();    
		    //need to grab this input
		    //need to save this input to a variable
		    //validation for acceptable move needs to sit here, will be hardcoded for computer players. check that input is a number 1-7, then check that chosen column isn't full
		    //getMove function could return this as a validated int that's had 1 subtracted from it, to match array index
		    //pass validated -1 int to game.java?
	
		
	}
	}

