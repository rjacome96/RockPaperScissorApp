package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class StartScreenController extends AnchorPane {
	public Scene startHere(Scene startScreen) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartScreenView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		try {
			startScreen = new Scene(loader.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return startScreen;
	}
}
