package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScreenController extends AnchorPane {
	
	@FXML
	private ImageView rockImage;
	@FXML
	private ImageView paperImage;
	@FXML
	private ImageView scissorImage;
	
	public static Scene getStartScreenScene() {
		return new StartScreenController().createStartScreen();
	}
	
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
}
