package application;
	
import java.util.EmptyStackException;
import java.util.Stack;

import controller.MainMenuScreenController;
import controller.PlayAIScreenController;
import controller.PlayHumanScreenController;
import controller.StartScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * The entry point of the Application and the source where the
 * stages and scenes will be changed. Extends the Application
 * class so it can run JavaFX properly.
 * @author royjacome
 *
 */
public class RockPaperScissorMain extends Application {
	
	
	/*
	 * FOR EACH CLASS, FXML CAN BE SET USING INSTANCE INITIALIZERS
	 */
	
	private static Stage currentStage;
	
	private static Stage previousStage;
	
	private static Stage startStage;
	
	private static Stage mainMenuStage;
	
	private static Stage playAIStage;
	
	private static Stage playHumanStage;
	
	private static Scene startScreen;
	
	private static Scene mainMenuScreen;
	
	private static Scene playAIScreen;
	
	private static Scene playHumanScreen;
	
	private static Stack<Stage> stageStack = new Stack<>();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			startScreen = StartScreenController.getStartScreenScene();
			mainMenuScreen = MainMenuScreenController.getMainMenuScreen();
			playAIScreen = PlayAIScreenController.getPlayAIScreen();
			playHumanScreen = PlayHumanScreenController.getPlayHumanScreen();
			startScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// Set up main menu stage
		mainMenuStage = new Stage();
		mainMenuStage.setTitle("Main Menu");
		mainMenuStage.setResizable(false);
		mainMenuStage.setScene(mainMenuScreen);
		
		// Set up the AI play stage
		playAIStage = new Stage();
		playAIStage.setTitle("Playing against Computer!");
		playAIStage.setResizable(false);
		playAIStage.setScene(playAIScreen);
		
		// Set up the Human play stage
		playHumanStage = new Stage();
		playHumanStage.setTitle("Playing against Human!");
		playHumanStage.setResizable(false);
		playHumanStage.setScene(playHumanScreen);
		
		// Set up the start screen stage
		startStage = primaryStage;
		currentStage = startStage;
		previousStage = startStage;
		stageStack.push(currentStage);
		currentStage.setTitle("Welcome!");
		currentStage.setScene(startScreen);
		currentStage.setResizable(false);
		currentStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Helper method used to easily switch among
	 * stages.
	 * @param newStage
	 */
	private static void changeStageTo(Stage newStage) {
		previousStage = currentStage;
		currentStage.hide();
		newStage.show();
		currentStage = newStage;
		stageStack.push(currentStage);
	}
	
	/**
	 * Method is called whenever user wants to return to a previous scene.
	 * Stack pops the top scene.
	 */
	private static void changeToPreviousStage() {
		if(!stageStack.isEmpty()) {
			
			Stage stageToSwitchTo = stageStack.pop();
			try {
				stageToSwitchTo = stageStack.pop();
			}
			catch(EmptyStackException e) {
				System.out.println("Last stage was popped");
			}
			
			changeStageTo(stageToSwitchTo);
		}
	}
	
	public static void enterMainMenu() {
		changeStageTo(mainMenuStage);
	}

	public static void backToStartScreen() {
		changeStageTo(startStage);
	}

	public static void playAgainstHuman() {
		changeStageTo(playHumanStage);
	}

	public static void playAgainstAI() {
		changeStageTo(playAIStage);
	}

	public static void previousStage() {
		changeToPreviousStage();
	}
}
