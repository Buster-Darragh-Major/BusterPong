package context;

import javafx.concurrent.Task;

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
	private PlayerType _lastWinner = PlayerType.PLAYER2;
	private boolean _served = false;
	private boolean _paused = false;
	
	public Game() {
		_player1 = new Player(PlayerType.PLAYER1);
		_player2 = new Player(PlayerType.PLAYER2);
		_ball = new Ball();
	}
	
	public void setGameDimensions(int x, int y) {
		_width = x;
		_height = y;
		
		_player1.setX(_player1.getLeftPaddleWallFromWall());
		_player1.setY(_height / 2);
		
		_player2.setX(_width - _player2.getLeftPaddleWallFromWall());
		_player2.setY(_height / 2);
	}
	
	public void newMatch() {
		_served = false;
		_ball = new Ball();
	}
	
	public void serve() {
		_served = true;
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
	
	public void moveBall() {
		if (_served) {
			if ((_ball.getY() < 0) || (_ball.getY() > _height)) {
				_ball.changeVert();
			}
			
			if (_ball.getX() < 0) {
				_player2.incrementScore();
				_lastWinner = PlayerType.PLAYER2;
				newMatch();
			} else if (_ball.getX() > _width) {
				_player1.incrementScore();
				_lastWinner = PlayerType.PLAYER1;
				newMatch();
			}
			
			if (((_ball.getX() < _player1.getRightPaddleWallFromWall() + _player1.width()) && (_ball.getX() > _player1.getLeftPaddleWallFromWall() + _ball.getDeltaX())) && haveCollided(_player1, _ball)) {
				if (!_paused) {
					double distFromCenter =_ball.getY() - _player1.getBallServeY();
					double centerScalar = (distFromCenter / (_player1.height() / 2));
					_ball.scaleDeltaY(centerScalar);
					_ball.changeHorz();
					pauseBounceDetection();
				}
				
			} else if (((_ball.getX() > _player2.getX()) && (_ball.getX() < _player2.getX() + _player2.width() + _ball.getDeltaX())) && haveCollided(_player2, _ball)) {
				if (!_paused) {
					double distFromCenter =_ball.getY() - _player2.getBallServeY();
					double centerScalar = (distFromCenter / (_player2.height() / 2));
					_ball.scaleDeltaY(centerScalar);
					_ball.changeHorz();
					pauseBounceDetection();
				}
			}
			
			_ball.move();
		} else {
			if (_lastWinner == PlayerType.PLAYER1) {
				_ball.setStart(_player2.getX(), _player2.getBallServeY() + _ball.getRadius() / 2);
			} else if (_lastWinner == PlayerType.PLAYER2) {
				_ball.setStart(_player1.getX() + _player1.width() + _ball.getRadius(), _player1.getBallServeY() + _ball.getRadius() / 2);
			}
		}
	}
	
	private void pauseBounceDetection() {
		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				_paused = true;
				Thread.sleep(100);
				_paused = false;
				return null;
			}
			
		};
		
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}
		
	
	private boolean haveCollided(Player player, Ball ball) {
		if ((ball.getY() > player.getUpperPaddleWall()) && (ball.getY() < player.getLowerPaddleWall())) {
			return true;
		} else {
			return false;
		}
	}
}
