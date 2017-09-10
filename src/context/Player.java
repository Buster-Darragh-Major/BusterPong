package context;

import context.Game.PlayerType;

public class Player {
	
	private static final int DEFAULT_SCORE = 0;
	private static final int DEFAULT_WIDTH = 10;
	private static final int DEFAULT_HEIGHT = 50;
	private static final int DEFAULT_X_FROM_WALL = 30;
	private static final int DEFAULT_SPEED = 5;
	
	private final PlayerType _playerType;
	private int _score;
	private int _xFromWall;
	private int _y;
	private int _width;
	private int _height;
	private int _speed;

	public Player (PlayerType playerType) {
		_playerType = playerType;
		_score = DEFAULT_SCORE;
		_width = DEFAULT_WIDTH;
		_height = DEFAULT_HEIGHT;
		_xFromWall = DEFAULT_X_FROM_WALL;
		_speed = DEFAULT_SPEED;
	}
	
	public void incrementScore() {
		_score++;
	}
	
	public int getScore() {
		return _score;
	}
	
	public PlayerType getPlayerType() {
		return _playerType;
	}
	
	public int getXFromWall() {
		return _xFromWall;
	}
	
	public int getY() {
		return _y;
	}
	
	public int width() {
		return _width;
	}
	
	public int height() {
		return _height;
	}
	
	public void moveUp() {
		_y -= _speed;
	}
	
	public void moveDown() {
		_y += _speed;
	}
	
	public void setStart(int y) {
		_y = y - (_height / 2);
	}
	
	public void setSpeed(int speed) {
		_speed = speed;
	}
	
	public int getUpperPaddleWall() {
		return _y;
	}
	
	public int getLowerPaddleWall() {
		return _y + _height;
	}
}
