package painting;

import context.Ball;
import javafx.scene.canvas.GraphicsContext;

public class PaintBall extends PaintPong {
	
	private Ball _ball;
	
	private int _x;
	private int _y;
	private int _radius;
	
	
	public PaintBall(Ball ball, GraphicsContext gc) {
		super(gc);
		
		_ball = ball;
		
		update();
	}
	
	public void update() {
		_radius = _ball.getRadius();
		_x = _ball.getX() - _radius;
		_y = _ball.getY() - _radius;
	}
	
	public void paint() {
		_gc.fillOval(_x, _y, _radius, _radius);
	}
}
