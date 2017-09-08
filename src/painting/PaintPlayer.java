package painting;

import context.Game.PlayerType;
import context.Player;
import javafx.scene.canvas.GraphicsContext;

public class PaintPlayer extends PaintPong {
	
	private int _xFromWall;
	private int _y;
	private int _paddleHeight;
	private int _paddleWidth;
	private PlayerType _playerType;

	public PaintPlayer(Player player, GraphicsContext gc) {
		super(gc);
		
		_xFromWall = player.getXFromWall();
		_y = player.getY();
		_paddleHeight = player.height();
		_paddleWidth = player.width();
		_playerType = player.getPlayerType();
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
