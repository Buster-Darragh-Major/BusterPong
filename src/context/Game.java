package context;

public class Game {
	
	public enum PlayerType {
		PLAYER1, PLAYER2
	}
	
	// Game objects
	private Player _player1;
	private Player _player2;
	private Ball _ball;
	
	// Game Parameters
	private int _width;
	private int _height;
	
	public Game() {
		_player1 = new Player(PlayerType.PLAYER1);
		_player2 = new Player(PlayerType.PLAYER2);
		_ball = new Ball();
	}
	
	public void setGameDimensions(int x, int y) {
		_width = x;
		_height = y;
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
	
	public void p1Up() {
		if (_player1.getUpperPaddleWall() > 0) {
			_player1.moveUp();
		}
	}
	
	public void p1Down() {
		if (_player1.getLowerPaddleWall() < _height) {
			_player1.moveDown();
		}
	}
	
	public void p2Up() {
		if (_player2.getUpperPaddleWall() > 0) {
			_player2.moveUp();
		}
	}
	
	public void p2Down() {
		if (_player2.getLowerPaddleWall() < _height) {
			_player2.moveDown();
		}
	}
}
