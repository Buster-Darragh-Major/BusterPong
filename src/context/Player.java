package context;

import context.Game.PlayerType;

public class Player {
	
	private static final int DEFAULT_SCORE = 0;
	private static final int DEFAULT_WIDTH = 10;
	private static final int DEFAULT_HEIGHT = 50;
	private static final int DEFAULT_X_FROM_WALL = 30;
	private static final int DEFAULT_SPEED = 10;
	
	private final PlayerType _playerType;
	private int _score;
	private int _xFromWall;
	private int _x;
	private int _y;
	private int _width;
	private int _height;
	private int _speed;

	public Player (PlayerType playerType) {
		_playerType = playerType;
		_score = DEFAULT_SCORE;
		_width = DEFAULT_WIDTH;
		_height = DEFAULT_HEIGHT;
		_speed = DEFAULT_SPEED;
		
		if (playerType == PlayerType.PLAYER1) {
			_xFromWall = DEFAULT_X_FROM_WALL;
		} else if (playerType == PlayerType.PLAYER2) {
			_xFromWall = DEFAULT_X_FROM_WALL + _width;
		}
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
	
	public void setX(int x) {
		_x = x;
	}
	
	public void setY(int y) {
		_y = y;
	}
	
	public int getX() {
		return _x;
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
	
	public void setSpeed(int speed) {
		_speed = speed;
	}
	
	public int getUpperPaddleWall() {
		return _y;
	}
	
	public int getLowerPaddleWall() {
		return _y + _height;
	}
	
	public int getLeftPaddleWallFromWall() {
		return _xFromWall;
	}
	
	public int getRightPaddleWallFromWall() {
		return _xFromWall + _width;
	}
	
	public int getBallServeY() {
		return _y + (_height / 2);
	}
}
