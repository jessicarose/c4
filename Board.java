package connect4;

import java.util.Arrays;

public class Board {
	  //declares how many cols the board is
	  private int w = 7;
	  //declares how many rows the board is
	  private int h = 6;
	//define board
	  char boardSpaces [][] = new char[6][7];
	  //method to define a board
	  public void defineBoard(){
	    for (int i = 0; i < h; i++) {
	    Arrays.fill(boardSpaces[i] = new char[w], '.');
	  }
	  }
	  public void drawBoard() {
		 for (int j = 0; j < h; j++) {
			 System.out.println(boardSpaces[j]);
		 }
	
	  }

	}
