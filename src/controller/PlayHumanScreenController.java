package controller;

import java.io.IOException;

import application.RockPaperScissorMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class PlayHumanScreenController extends AnchorPane {
	
	@FXML
	Text resultText;
	
	@FXML
	ImageView player1Image, player2Image;

	private PlayHumanScreenController() {
		
	}
	
	public static Scene getPlayHumanScreen() {
		return new PlayHumanScreenController().createPlayHumanScreen();
	}
	
	private Scene createPlayHumanScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlayHumanScreenView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		Scene playHumanScreen = null;
		try {
			playHumanScreen = new Scene(loader.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		return playHumanScreen;
	}
	
	public void resetButtonPressed(ActionEvent event) {
		System.out.println("Reset button pressed");
	}
	
	/**
	 * Method is called when the user presses the back button
	 * to return to the previous screen.
	 * @param event
	 */
	public void backButtonPressed(ActionEvent event) {
		RockPaperScissorMain.previousStage();
	}
}
