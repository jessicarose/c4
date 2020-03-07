package connect4;

import java.util.Arrays;

public class Board {
	  //declares how many cols the board is
	  private int rows = 7;
	  //declares how many rows the board is
	  private int columns = 6;
	//define board
	  char boardSpaces [][] = new char[6][7];
	  //method to define a board
	  public void defineBoard(){
	    for (int i = 0; i < columns; i++) {
	    Arrays.fill(boardSpaces[i] = new char[rows], '.');
	  }
	  }
	  public void drawBoard() {
		  //shows human user col number for play
		  System.out.println("1234567");
		 for (int j = 0; j < columns; j++) {
			 System.out.println(boardSpaces[j]);
		 }
	
	  }

	}
