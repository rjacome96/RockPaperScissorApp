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
import javafx.scene.text.Text;

public class PlayAIScreenController extends AnchorPane {
	
	@FXML
	private Text resultText;
	
	@FXML
	private ImageView slidingDoor, aiChoice;
	
	private static double CLOSED_SLIDING_DOOR_X;
	private static double CLOSED_SLIDING_DOOR_Y;
	private static double DOOR_OPENED_Y = -138;
	
	private static Image[] choices = {new Image("File:gameImages/RockClipArt.png"),
			new Image("File:gameImages/PaperClipArt.png"),
			new Image("File:gameImages/ScissorClipArt.png")};
	
	private static final Image AI_DEFAULT_CHOICE = new Image("File:gameImages/AIThinkingClipArt.png");
	
	private static AnimationTimer openSlidingDoor = null;
	private static AnimationTimer closeSlidingDoor = null;
		
	
	{
		openSlidingDoor = new AnimationTimer(){	
			@Override
	        public void handle(long currentNanoTime){
				double currentDoorY = slidingDoor.getLayoutY();
				
				if(currentDoorY > DOOR_OPENED_Y) {
					System.out.println(currentDoorY);
					slidingDoor.setLayoutY(currentDoorY - 2);
				}
				else {
					stop();
				}
				
				System.out.println("Opening " + currentDoorY);
	        }
	    };
	    
	    closeSlidingDoor = new AnimationTimer() {

			@Override
			public void handle(long now) {
				double currentDoorY = slidingDoor.getLayoutY();
				
				if(currentDoorY < CLOSED_SLIDING_DOOR_Y) {
					System.out.println(currentDoorY);
					slidingDoor.setLayoutY(currentDoorY + 2);
				}
				else {
					stop();
				}
				
				System.out.println("Closing" + currentDoorY);
				
			}
	    	
	    };
	}
	
	/**
	 * Overriding the default no arg constructor
	 * to make it private.
	 */
	private PlayAIScreenController() {
		
	}

	/**
	 * Creates this class Object and calls the method to create the scene
	 * that this class uses.
	 * @return The scene that was returned from the {@link createPlayAIScreen}.
	 */
	public static Scene getPlayAIScreen() {
		return new PlayAIScreenController().createPlayAIScreen();
	}

	/**
	 * Loads the FXML file into the class and sets this class as the controller.
	 * As well as sets up the AnimationTimer to move the image of the sliding door.
	 * @return The scene that this class will uses.
	 */
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
		
	    
	    CLOSED_SLIDING_DOOR_X = slidingDoor.getLayoutX();
	    CLOSED_SLIDING_DOOR_Y = slidingDoor.getLayoutY();
	    resultText.setOpacity(0);
	    
		return playAIScreen;
	}
	
	/**
	 * Method that begins the animation timer.
	 */
	public static void startAnimationTimer() {
		//openSlidingDoor.start();
	}
	
	/**
	 * Method that stops the animation timer.
	 */
	public static void stopAnimationTimer() {
		//openSlidingDoor.stop();
	}
	
	/**
	 * Method to catch that the user selected the rock.
	 * @param event
	 */
	public void rockSelected(MouseEvent event) {
		System.out.println("Rock selected");
	}
	
	/**
	 * Method to catch that the user selected the paper.
	 * @param event
	 */
	public void paperSelected(MouseEvent event) {
		System.out.println("Paper selected");
	}
	
	/**
	 * Method to catch that the user selected the scissor.
	 * @param event
	 */
	public void scissorSelected(MouseEvent event) {
		System.out.println("Scissor selected");
	}
	
	/**
	 * Method that catches when the reset button is clicked
	 * @param event
	 */
	public void restartGame(ActionEvent event) {
		restartGame();
	}
	
	/**
	 * When called, the AI will be given a random choice to display
	 * the image as its own choice.
	 * @return The move the that the AI chose.
	 */
	public Object makeAIChoose() {
		// TODO Create the classes and return the appropriate class
		int random = (int)(Math.random() * 3); 
        aiChoice.setImage(choices[random]);
        return null;
	}
	
	/**
	 * Resets the sliding door back to its closing position.
	 */
	private void resetSlidingDoor() {
		slidingDoor.setLayoutX(CLOSED_SLIDING_DOOR_X);
		slidingDoor.setLayoutY(CLOSED_SLIDING_DOOR_Y);
	}
	
	/**
	 * Changes the image for the AI back to default.
	 */
	private void resetAIChoice() {
		aiChoice.setImage(AI_DEFAULT_CHOICE);
	}
	
	/**
	 * Called when the player clicks on the back button.
	 * @param e
	 */
	public void previousStage(ActionEvent e) {
		stopAnimationTimer();
		RockPaperScissorMain.previousStage();
	}

	/**
	 * Resets all values and puts the game back to
	 * the start, playing against the AI.
	 */
	private void restartGame() {
		System.out.println("Restart game button is pressed");
		resetAIChoice();
		resetSlidingDoor();
	}
}
