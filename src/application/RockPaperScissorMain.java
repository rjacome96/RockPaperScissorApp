package application;
	
import controller.StartScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class RockPaperScissorMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Scene startScreen = StartScreenController.getStartScreenScene();
			startScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Welcome!");
			primaryStage.setScene(startScreen);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static void startGame() {
		System.out.println("Start button pressed");
	}
}
