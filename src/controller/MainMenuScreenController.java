package controller;

import java.io.IOException;

import application.RockPaperScissorMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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

	public void startHumanVsHuman(MouseEvent event) {
		System.out.println("Human Vs Human");
	}
	
	public void startHumanVsAI(MouseEvent event) {
		System.out.println("Human Vs AI");
	}
}
