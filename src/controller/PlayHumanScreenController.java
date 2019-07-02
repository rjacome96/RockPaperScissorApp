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
	ImageView player1Image, player1SlidingDoor, player2Image, player2SlidingDoor;

	/**
	 * Overwrite the default no argument constructor so that it
	 * can be set to private.
	 */
	private PlayHumanScreenController() {
		
	}
	
	/**
	 * Static method that allows the main application
	 * to call and get the {@code Scene} that the method returns.
	 * This method calls the {@link createPlayHumanScreen} method in
	 * order to retrieve the {@code Scene}.
	 * @return
	 */
	public static Scene getPlayHumanScreen() {
		return new PlayHumanScreenController().createPlayHumanScreen();
	}
	
	/**
	 * Loads the FXML file into the controller and sets it to this 
	 * specific scene.
	 * @return
	 */
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
	
	/**
	 * Method called when the reset button is clicked by
	 * the user.
	 * @param event
	 */
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
