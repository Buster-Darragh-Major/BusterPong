package pongApp;

import java.net.URL;
import java.util.ResourceBundle;

import context.Context;
import context.Game;
import javafx.animation.AnimationTimer;
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
	private Canvas _gameWindow;
	
	private Game _game;
	
	// User Input Variables
	private boolean _wIsPressed = false;
	private boolean _sIsPressed = false;
	private boolean _upIsPressed = false;
	private boolean _downIsPressed = false;
	
	@FXML
	public void handleKeyStroke(KeyEvent e) {
		if (e.getCode().toString() == "W") {
			_wIsPressed = true;
		} else if (e.getCode().toString() == "S") {
			_sIsPressed = true;
		} else if (e.getCode().toString() == "UP") {
			_upIsPressed = true;
		} else if (e.getCode().toString() == "DOWN") {
			_downIsPressed = true;
		} else if (e.getCode().toString() == "SPACE") {
			serve();
		}
	}
	
	@FXML
	public void handleKeyRelease(KeyEvent e) {
		if (e.getCode().toString() == "W") {
			_wIsPressed = false;
		} else if (e.getCode().toString() == "S") {
			_sIsPressed = false;
		} else if (e.getCode().toString() == "UP") {
			_upIsPressed = false;
		} else if (e.getCode().toString() == "DOWN") {
			_downIsPressed = false;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Retrieve game object
		Context.getInstance().newGame();
		_game = Context.getInstance().currentGame();
		_game.setGameDimensions((int) _gameWindow.getWidth(), (int) _gameWindow.getHeight());
		
		// Set scores
		_player1Score.setText(_game.getPlayer1().getScore() + "");
		_player2Score.setText(_game.getPlayer2().getScore() + "");
		
		// Paint paddles, Ball and graphics context
		GraphicsContext gc = _gameWindow.getGraphicsContext2D();
		PaintPlayer paintPlayer1 = new PaintPlayer(_game.getPlayer1(), gc);
		PaintPlayer paintPlayer2 = new PaintPlayer(_game.getPlayer2(), gc);
		PaintBall paintBall = new PaintBall(_game, gc);
		
		// Begin animation
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				if (_wIsPressed) {
					_game.p1Up();
				}
				if (_sIsPressed) {
					_game.p1Down();
				}
				if (_upIsPressed) {
					_game.p2Up();
				}
				if (_downIsPressed) {
					_game.p2Down();
				}
				_game.moveBall();
				
				gc.clearRect(0, 0, 1000, 1000);
				
				paintPlayer1.update();
				paintPlayer1.paint();
				
				paintPlayer2.update();
				paintPlayer2.paint();
				
				paintBall.update();
				paintBall.paint();
			}
		};
		
		timer.start();
	}
	
	private void serve() {
		_game.serve();
	}
}
