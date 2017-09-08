package pongApp;

import java.net.URL;
import java.util.ResourceBundle;

import context.Ball;
import context.Context;
import context.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import painting.PaintBall;
import painting.PaintPlayer;

public class GameWindowController implements Initializable {
	
	
	
	// Game Window
	@FXML
	private Pane _pane;
	@FXML
	private Label _player1Score = new Label();
	@FXML
	private Label _player2Score = new Label();
	@FXML
	private Canvas _gameWindow = new Canvas();
	
	private Player _player1;
	private Player _player2;
	private Ball _ball;
	private PaintPlayer _paintPlayer1;
	private PaintPlayer _paintPlayer2;
	private PaintBall _paintBall;
	private GraphicsContext _gc;

	@FXML
	public void handleKeyStroke(KeyEvent e) {
		System.out.println(e.getCode().toString());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Retrieve game objects
		Context.getInstance().newGame();
		_player1 = Context.getInstance().currentGame().getPlayer1();
		_player2 = Context.getInstance().currentGame().getPlayer2();
		_ball = Context.getInstance().currentGame().getBall();
		
		// Set default scores
		_player1Score.setText(_player1.getScore() + "");
		_player2Score.setText(_player2.getScore() + "");
		
		// Set default ball location
		_ball.setStart((int) _gameWindow.getWidth() / 2, (int) _gameWindow.getHeight() / 2);
		
		// Paint paddles, Ball and graphics context
		_gc = _gameWindow.getGraphicsContext2D();
		_paintPlayer1 = new PaintPlayer(_player1, _gc);
		_paintPlayer2 = new PaintPlayer(_player2, _gc);
		_paintBall = new PaintBall(_ball, _gc);
		_paintPlayer1.paint();
		_paintPlayer2.paint();
		_paintBall.paint();
	}
}
