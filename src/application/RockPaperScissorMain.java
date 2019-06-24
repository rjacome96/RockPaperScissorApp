package application;
	
import controller.MainMenuScreenController;
import controller.StartScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class RockPaperScissorMain extends Application {
	
	private Stage startStage;
	
	private Stage mainMenuStage;
	
	private Scene startScreen;
	
	private Scene mainMenuScreen;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			startScreen = StartScreenController.getStartScreenScene();
			mainMenuScreen = MainMenuScreenController.getMainMenuScreen();
			startScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		startStage = primaryStage;
		startStage.setTitle("Welcome!");
		startStage.setScene(startScreen);
		startStage.show();
		startStage.setResizable(false);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static void startGame() {
		System.out.println("Start button pressed");
	}
}
