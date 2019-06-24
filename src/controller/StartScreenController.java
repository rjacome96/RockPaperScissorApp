package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.image.ImageView;
//import javafx.scene.image.Image;
//import javafx.scene.canvas.Canvas;
//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;

/**
 * Controller for the Start Screen of the game. As of now only contains
 * the images for the game displayed on the screen and the start button.
 * @author Roy Jacome
 *
 */
public class StartScreenController extends AnchorPane {
	
	@FXML
	private ImageView rockImage;
	@FXML
	private ImageView paperImage;
	@FXML
	private ImageView scissorImage;
	@FXML
	private Button startButton;
	
	/**
	 * A static method that allows the main
	 * application to call the private method {@link createStartScreen}.
	 * @return The scene that is returned from calling the method.
	 */
	public static Scene getStartScreenScene() {
		return new StartScreenController().createStartScreen();
	}
	
	/**
	 * Loads the FXML file so that this class can control the scene.
	 * @return The start screen that the player will be introduced to.
	 */
	private Scene createStartScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/StartScreenView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		Scene startScreen = null;
		try {
			startScreen = new Scene(loader.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//rockImage.setImage(new Image("File:gameImages/RockClipArt.png"));
		//paperImage.setImage(new Image("File:gameImages/PaperClipArt.png"));
		//scissorImage.setImage(new Image("File:gameImages/ScissorClipArt.png"));
		
		
		// Testing out Canvas and GraphicsContent
		/*
		Canvas canvas = new Canvas(400, 200);
		GraphicsContext gc = canvas.getGraphicsContext2D();
	    gc.setFill(Color.RED);
	    gc.setStroke(Color.BLACK);
	    gc.setLineWidth(2);
	    Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
	    gc.setFont(theFont);
	    gc.fillText("Hello, World!", 60, 50);
	    gc.strokeText("Hello, World!", 60, 50);
	    //this.getChildren().add(canvas);
	    
	    //gc.drawImage(rock, 14, 237);
	    */
	    
		return startScreen;
	}
	
	public void startGame(ActionEvent event) {
		System.out.println("Button works");
	}
}
