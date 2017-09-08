package painting;

import context.Ball;
import javafx.scene.canvas.GraphicsContext;

public class PaintBall extends PaintPong {
	
	private int _x;
	private int _y;
	private int _deltaX;
	private int _deltaY;
	private int _radius;
	
	
	public PaintBall(Ball ball, GraphicsContext gc) {
		super(gc);
		
		_radius = ball.getRadius();
		_x = ball.getX() - _radius;
		_y = ball.getY() - _radius;
		_deltaX = ball.getDeltaX();
		_deltaY = ball.getDeltaY();
	}
	
	public void paint() {
		_gc.fillOval(_x, _y, _radius, _radius);
	}
}
