package Window;

import Game.Game;

public class Main {

	public static void main(String[] args) {
		Game game = new Game("Centipede", 800, 800+32);
		game.start();
	}
	
}
