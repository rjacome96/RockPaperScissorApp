package application;
	
import controller.StartScreenController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class RockPaperScissorMain extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = new AnchorPane();
			Scene startScreen = new Scene(root,400,400);
			startScreen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			startScreen = new StartScreenController().startHere(startScreen);
			primaryStage.setTitle("Welcome!");
			primaryStage.setScene(startScreen);
			primaryStage.show();
			primaryStage.setResizable(true);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
