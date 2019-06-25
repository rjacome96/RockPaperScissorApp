package controller;

import java.io.IOException;

import application.RockPaperScissorMain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class PlayAIScreenController extends AnchorPane {
	
	private PlayAIScreenController() {
		
	}

	public static Scene getPlayAIScreen() {
		return new PlayAIScreenController().createPlayAIScreen();
	}

	private Scene createPlayAIScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlayAIScreenView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		Scene playAIScreen = null;
		try {
			playAIScreen = new Scene(loader.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return playAIScreen;
	}
	
	public void previousStage() {
		RockPaperScissorMain.previousStage();
	}

}
