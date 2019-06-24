package application;
	
import controller.MainMenuScreenController;
import controller.StartScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class RockPaperScissorMain extends Application {
	
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
		startStage.setTitle("Welcome!");
		startStage.setScene(startScreen);
		startStage.setResizable(false);
		startStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static void startGame() {
		startStage.hide();
		mainMenuStage.show();
		System.out.println("Start button pressed");
	}
}
