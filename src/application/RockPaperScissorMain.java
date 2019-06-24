package application;
	
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
}
