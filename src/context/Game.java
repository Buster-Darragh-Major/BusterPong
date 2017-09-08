package context;

public class Game {
	
	public enum PlayerType {
		PLAYER1, PLAYER2
	}
	
	private Player _player1;
	private Player _player2;
	private Ball _ball;
	
	public Game() {
		_player1 = new Player(PlayerType.PLAYER1);
		_player2 = new Player(PlayerType.PLAYER2);
		_ball = new Ball();
	}
	
	public Player getPlayer1() {
		return _player1;
	}

	public Player getPlayer2() {
		return _player2;
	}
	
	public Ball getBall() {
		return _ball;
	}
}
