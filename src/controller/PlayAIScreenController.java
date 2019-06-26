package controller;

import java.io.IOException;

import application.RockPaperScissorMain;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PlayAIScreenController extends AnchorPane {
	
	@FXML
	private ImageView aiChoice;
	
	private Image[] choices = {new Image("File:gameImages/RockClipArt.png"),
			new Image("File:gameImages/PaperClipArt.png"),
			new Image("File:gameImages/ScissorClipArt.png")};
	
	private static AnimationTimer programButtonAnimation = null;
		
	/**
	 * Overriding the default no arg constructor
	 * to make it private.
	 */
	private PlayAIScreenController() {
		
	}

	public static Scene getPlayAIScreen() {
		return new PlayAIScreenController().createPlayAIScreen();
	}

	private Scene createPlayAIScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlayAIScreenView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		Scene playAIScreen = null;
		try {
			playAIScreen = new Scene(loader.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		programButtonAnimation = new AnimationTimer(){	
			@Override
	        public void handle(long currentNanoTime){
	 
	            int random = (int)(Math.random() * 3); 
	            aiChoice.setImage(choices[random]);
	        }
	    };
	    
		return playAIScreen;
	}
	
	public static void startAnimationTimer() {
		programButtonAnimation.start();
	}
	
	public static void stopAnimationTimer() {
		programButtonAnimation.stop();
	}
	
	public void rockSelected(MouseEvent event) {
		System.out.println("Rock selected");
	}
	
	public void paperSelected(MouseEvent event) {
		System.out.println("Paper selected");
	}

	public void scissorSelected(MouseEvent event) {
		System.out.println("Scissor selected");
	}
	
	public void restartGame(ActionEvent event) {
		System.out.println("Restart game button is pressed");
	}
	
	public void previousStage(ActionEvent e) {
		stopAnimationTimer();
		RockPaperScissorMain.previousStage();
	}

}
