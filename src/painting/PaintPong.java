package painting;

import javafx.scene.canvas.GraphicsContext;

public abstract class PaintPong {
	
	protected int _canvasHeight;
	protected int _canvasWidth;
	protected GraphicsContext _gc;
	
	protected PaintPong(GraphicsContext gc) {
		_canvasHeight = (int) gc.getCanvas().getHeight();
		_canvasWidth = (int) gc.getCanvas().getWidth();
		_gc = gc;
	}

	public abstract void paint();
	
	public abstract void update();
}
