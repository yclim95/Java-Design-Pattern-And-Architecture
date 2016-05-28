public class App {
	public static void main(String[] args) {

		Game game = new Game();

		// Game loop (Infinite loop)
		while (true) {
			game.update();
		}
	}
}