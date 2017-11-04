package painting;

import context.Player;
import context.PlayerType;
import javafx.scene.canvas.GraphicsContext;

public class PaintPlayer extends PaintPong {
	
	private Player _player;
	
	private int _xFromWall;
	private int _y;
	private int _paddleHeight;
	private int _paddleWidth;
	private PlayerType _playerType;

	public PaintPlayer(Player player, GraphicsContext gc) {
		super(gc);
		
		_player = player;
		
		update();
	}
	
	public void update() {
		_xFromWall = _player.getLeftPaddleWallFromWall();
		_y = _player.getY();
		_paddleHeight = _player.height();
		_paddleWidth = _player.width();
		_playerType = _player.getPlayerType();
	}
	
	public void paint() {
		int x = 0;
		if (_playerType == PlayerType.PLAYER1) {
			x = _xFromWall;
		} else if (_playerType == PlayerType.PLAYER2) {
			x = _canvasWidth - _xFromWall;
		}
		
		_gc.fillRect(x, _y, _paddleWidth, _paddleHeight);
	}
}
