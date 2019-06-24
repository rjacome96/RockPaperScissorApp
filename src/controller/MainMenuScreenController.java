package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class MainMenuScreenController extends AnchorPane {
	
	/**
	 * Override default constructor so that it can be made private.
	 */
	private MainMenuScreenController() {
		
	}

	public static Scene getMainMenuScreen() {
		return new MainMenuScreenController().createMainMenuScreen();
	}

	private Scene createMainMenuScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainMenuScreenView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		Scene mainMenuScreen = null;
		try {
			mainMenuScreen = new Scene(loader.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return mainMenuScreen;
	}

}
