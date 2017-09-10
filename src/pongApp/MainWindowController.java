package pongApp;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController {

	// Main Menu
	@FXML
	private Button _mainMenuPlay;
	
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
		scene.getRoot().requestFocus();
	}
}
