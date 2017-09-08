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
		
		_x = ball.getX();
		_y = ball.getX();
		_deltaX = ball.getDeltaX();
		_deltaY = ball.getDeltaY();
		_radius = ball.getRadius();
	}
	
	public void paint() {
		
	}
}
