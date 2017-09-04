package pongApp;

import java.awt.Point;

import javafx.scene.canvas.Canvas;

public class PongModel {
	
	
	
	private final static double DEFAULT_P1_X_DIST = 20;
	private final static double DEFAULT_P1_Y_DIST = 50;
	private final static double DEFAULT_P2_X_DIST = 20;
	private final static double DEFAULT_P2_Y_DIST = 50;
	private final static double DEFAULT_PADDLE_THICKNESS = 10;
	private final static double DEFAULT_PADDLE_HEIGHT = 30;
	
	private Point _p1Coord = new Point();
	private Point _p2Coord = new Point();
	
	private double _windowHeight;
	private double _windowWidth;
	
	
	
	public PongModel(Canvas gameWindow) {
		_windowHeight = gameWindow.getHeight();
		_windowWidth = gameWindow.getWidth();
		
		_p1Coord.setLocation(DEFAULT_P1_X_DIST, DEFAULT_P1_Y_DIST);
		_p2Coord.setLocation(_windowWidth - DEFAULT_P2_X_DIST, _windowHeight - DEFAULT_P2_Y_DIST);
	}
	
	
	
	public double getP1Y() {
		return _p1Coord.getY();
	}
	
	public double getP1X() {
		return _p1Coord.getX();
	}
	
	public double getP2Y() {
		return _p2Coord.getY();
	}
	
	public double getP2X() {
		return _p2Coord.getX();
	}
	
	public void moveP1Up() {
		_p1Coord.setLocation(_p1Coord.getX(), _p1Coord.getY() - 1);
	}
	
	public void moveP1Down() {
		_p1Coord.setLocation(_p1Coord.getX(), _p1Coord.getY() + 1);
	}
	
	public void moveP2Up() {
		_p1Coord.setLocation(_p2Coord.getX(), _p1Coord.getY() - 1);
	}
	
	public void moveP2Down() {
		_p1Coord.setLocation(_p2Coord.getX(), _p1Coord.getY() + 1);
	}
	
}
