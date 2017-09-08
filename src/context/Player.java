package context;

import context.Game.PlayerType;

public class Player {
	
	private static final int DEFAULT_SCORE = 0;
	private static final int DEFAULT_WIDTH = 10;
	private static final int DEFAULT_HEIGHT = 50;
	private static final int DEFAULT_X_FROM_WALL = 30;
	private static final int DEFAULT_Y = 50;
	
	private final PlayerType _playerType;
	private int _score;
	private int _xFromWall;
	private int _y;
	private int _width;
	private int _height;

	public Player (PlayerType playerType) {
		_playerType = playerType;
		_score = DEFAULT_SCORE;
		_width = DEFAULT_WIDTH;
		_height = DEFAULT_HEIGHT;
		_xFromWall = DEFAULT_X_FROM_WALL;
		_y = DEFAULT_Y;
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
		_y--;
	}
	
	public void moveDown() {
		_y++;
	}
}
