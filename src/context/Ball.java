package context;

public class Ball {
	
	private static final int DEFAULT_DELTA_X = 5;
	private static final int DEFAULT_DELTA_Y = 4;
	private static final int DEFAULT_RADIUS = 10;
	
	private int _x;
	private int _y;
	private int _deltaX;
	private int _deltaY;
	private int _radius;
	
	public Ball() {
		_deltaX = DEFAULT_DELTA_X;
		_deltaY = DEFAULT_DELTA_Y;
		_radius = DEFAULT_RADIUS;
	}
	
	public int getX() {
		return _x;
	}
	
	public int getY() {
		return _y;
	}
	
	public int getDeltaX() {
		return _deltaX;
	}
	
	public int getDeltaY() {
		return _deltaY;
	}
	
	public int getRadius() {
		return _radius;
	}
	
	public void move() {
		_x += _deltaX;
		_y += _deltaY;
	}
	
	public void changeVert() {
		_deltaY = -_deltaY;
	}
	
	public void changeHorz() {
		_deltaX = -_deltaX;
	}
	
	public void setStart(int x, int y) {
		_x = x;
		_y = y;
	}
	
	public void scaleDeltaY(double scalar) {
		if (Math.abs(_deltaY) < 1.5 * DEFAULT_DELTA_Y) {
			if (_deltaY > 0) {
				_deltaY += DEFAULT_DELTA_Y * scalar;
			} else {
				_deltaY -= DEFAULT_DELTA_Y * scalar;
			}
		}
	}
}
