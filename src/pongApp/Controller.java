package pongApp;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controller implements Initializable {

	// Main Menu
	@FXML
	private Button _mainMenuPlay;
	
	// Game Window
	@FXML
	private Label _player1Score = new Label();
	@FXML
	private Label _player2Score = new Label();;
	@FXML
	private Canvas _gameWindow = new Canvas();;
	
	private final static String DEFAULT_PLAYER_1_SCORE = "0";
	private final static String DEFAULT_PLAYER_2_SCORE = "0";
	
	private PongModel _model;
	
	@FXML
	public void handleMainMenuPlayClick() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("GameWindow.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = (Stage) _mainMenuPlay.getScene().getWindow();
		
		Scene scene = new Scene(root);	
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	public void handleKeyStroke(KeyEvent e) {
		System.out.println("key pressed");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		_player1Score.setText(DEFAULT_PLAYER_1_SCORE);
		_player2Score.setText(DEFAULT_PLAYER_2_SCORE);
		
		_model = new PongModel(_gameWindow);
	}
}
