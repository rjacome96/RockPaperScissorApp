package application;
	
import controller.MainMenuScreenController;
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
	
	private static Stage currentStage;
	
	private static Stage startStage;
	
	private static Stage mainMenuStage;
	
	private static Scene startScreen;
	
	private static Scene mainMenuScreen;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			startScreen = StartScreenController.getStartScreenScene();
			mainMenuScreen = MainMenuScreenController.getMainMenuScreen();
			startScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		mainMenuStage = new Stage();
		mainMenuStage.setTitle("Main Menu");
		mainMenuStage.setScene(mainMenuScreen);
		mainMenuStage.setResizable(false);
		
		
		startStage = primaryStage;
		currentStage = startStage;
		currentStage.setTitle("Welcome!");
		currentStage.setScene(startScreen);
		currentStage.setResizable(false);
		currentStage.show();
	}
	
	private static void changeStageTo(Stage newStage) {
		currentStage.hide();
		newStage.show();
		currentStage = newStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static void enterMainMenu() {
		changeStageTo(mainMenuStage);
	}

	public static void backToStartScreen() {
		changeStageTo(startStage);
		
	}

	public static void playAgainstHuman() {
		//changeStageTo(humanStage);
	}

	public static void playAgainstAI() {
		//changeStageTo(playAIStage);
	}
}
