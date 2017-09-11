package painting;

import context.Ball;
import context.Game;
import javafx.scene.canvas.GraphicsContext;

public class PaintBall extends PaintPong {
	
	private Game _game;;
	
	private int _x;
	private int _y;
	private int _radius;
	
	
	public PaintBall(Game game, GraphicsContext gc) {
		super(gc);
		
		_game = game;
		
		update();
	}
	
	public void update() {
		Ball ball = _game.getBall();
		_radius = ball.getRadius();
		_x = ball.getX() - _radius;
		_y = ball.getY() - _radius;
	}
	
	public void paint() {
		_gc.fillOval(_x, _y, _radius, _radius);
	}
}
