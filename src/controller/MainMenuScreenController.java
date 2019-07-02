package controller;

import java.io.IOException;

import application.RockPaperScissorMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainMenuScreenController extends AnchorPane {
	
	/**
	 * Override default constructor so that it can be made private.
	 */
	private MainMenuScreenController() {
		
	}

	/**
	 * The static method that allows this class to be called
	 * and return a scene without having to make an object
	 * of this class. Calls {@link createMainMenuScreen} to do
	 * the work.
	 * @return Returns the scene that was returned from the
	 * {@link createMainMenuScreen} method. 
	 */
	public static Scene getMainMenuScreen() {
		return new MainMenuScreenController().createMainMenuScreen();
	}

	/**
	 * Responsible for loading the FXML file and linking
	 * it to this class.
	 * @return Returns the connected scene back to the caller.
	 */
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
	
	/**
	 * Takes the event that the options button is pressed.
	 * @param event
	 */
	public void openOptions(ActionEvent event) {
		System.out.println("Open options");
	}
	
	/**
	 * When back button is pressed, call the method in main application
	 * to switch back to the start screen.
	 * @param event
	 */
	public void backToStartScreen(ActionEvent event) {
		RockPaperScissorMain.backToStartScreen();
	}
	
	public void previousStage(ActionEvent event) {
		RockPaperScissorMain.previousStage();
	}

	/**
	 * When player wants to play against a human, this method is run.
	 * It will tell the main application to switch stage and scene.
	 * @param event
	 */
	public void startHumanVsHuman(MouseEvent event) {
		RockPaperScissorMain.playAgainstHuman();
	}
	
	/**
	 * When player wants to play against AI, this method is run.
	 * It will tell the main application to switch stage and scene.
	 * @param event
	 */
	public void startHumanVsAI(MouseEvent event) {
		RockPaperScissorMain.playAgainstAI();
	}
}
