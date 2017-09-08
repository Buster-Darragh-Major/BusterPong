package context;

public class Context {
	
	private static final Context _context = new Context();
	
	private Game _game;
	
	private Context() {
		
	}

	public static Context getInstance() {
		return _context;
	}
	
	public void newGame() {
		_game = new Game();
	}
	
	public Game currentGame() {
		return _game;
	}
}
