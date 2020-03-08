package connect4;


class ComputerPlayer extends Player{

		public ComputerPlayer(char gameToken) {
			super(gameToken);
		}

		@Override
		int getMove() {
			//gets a random number between 1-7 for the computer's move
			int x = 1 + (int) (Math.random() * 7);
			System.out.println(x);
			return x;
		}
		
}
		


