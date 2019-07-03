package controller;

import java.io.IOException;

import application.RockPaperScissorMain;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import model.GameObject;

public class PlayHumanScreenController extends AnchorPane {
	
	@FXML
	private Text resultText;
	
	@FXML
	private ImageView player1Image, player1SlidingDoor, player2Image, player2SlidingDoor;
	
	@FXML
	private HBox player1HBox, player2HBox;
	
	private static GameObject player1Choice, player2Choice;
	
	private static double PLAYER1_CLOSED_SLIDING_DOOR_X, PLAYER2_CLOSED_SLIDING_DOOR_X;
	private static final double PLAYER1_DOOR_OPENED_X = -204, PLAYER2_DOOR_OPENED_X = 655;

	private static AnimationTimer openPlayer1SlidingDoor, closePlayer1SlidingDoor, openPlayer2SlidingDoor, closePlayer2SlidingDoor;
	
	private static boolean otherPlayerIsReady;
	
	/**
	 * Player 1's initialization block to create what the sliding door does
	 */
	{
		openPlayer1SlidingDoor = new AnimationTimer(){	
			@Override
	        public void handle(long currentNanoTime){
				double currentDoorX = player1SlidingDoor.getLayoutX();
				
				if(currentDoorX > PLAYER1_DOOR_OPENED_X) {
					player1SlidingDoor.setLayoutX(currentDoorX - 5);
				}
				else {
					stop();
				}
	        }
	    };
	    
	    closePlayer1SlidingDoor = new AnimationTimer() {

			@Override
			public void handle(long now) {
				double currentDoorX = player1SlidingDoor.getLayoutX();
				
				if(currentDoorX < PLAYER1_CLOSED_SLIDING_DOOR_X) {
					player1SlidingDoor.setLayoutX(currentDoorX + 5);
				}
				else {
					stop();
				}
			}
	    	
	    };
	}
	
	/**
	 * Player 2's initialization block to create what the sliding door does
	 */
	{
		openPlayer2SlidingDoor = new AnimationTimer(){	
			@Override
	        public void handle(long currentNanoTime){
				double currentDoorX = player2SlidingDoor.getLayoutX();
				
				if(currentDoorX < PLAYER2_DOOR_OPENED_X) {
					player2SlidingDoor.setLayoutX(currentDoorX + 5);
				}
				else {
					stop();
				}
	        }
	    };
	    
	    closePlayer2SlidingDoor = new AnimationTimer() {

			@Override
			public void handle(long now) {
				double currentDoorX = player2SlidingDoor.getLayoutX();
				
				if(currentDoorX > PLAYER2_CLOSED_SLIDING_DOOR_X) {
					player2SlidingDoor.setLayoutX(currentDoorX - 5);
				}
				else {
					stop();
				}
			}
	    	
	    };
	}

	/**
	 * Overwrite the default no argument constructor so that it
	 * can be set to private.
	 */
	private PlayHumanScreenController() {
		
	}
	
	/**
	 * Static method that allows the main application
	 * to call and get the {@code Scene} that the method returns.
	 * This method calls the {@link createPlayHumanScreen} method in
	 * order to retrieve the {@code Scene}.
	 * @return
	 */
	public static Scene getPlayHumanScreen() {
		return new PlayHumanScreenController().createPlayHumanScreen();
	}
	
	/**
	 * Loads the FXML file into the controller and sets it to this 
	 * specific scene.
	 * @return
	 */
	private Scene createPlayHumanScreen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PlayHumanScreenView.fxml"));
		loader.setController(this);
		loader.setRoot(this);
		Scene playHumanScreen = null;
		try {
			playHumanScreen = new Scene(loader.load());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		PLAYER1_CLOSED_SLIDING_DOOR_X = player1SlidingDoor.getLayoutX();
		PLAYER2_CLOSED_SLIDING_DOOR_X = player2SlidingDoor.getLayoutX();
		resetResultText();
		resetDoors();
		
		return playHumanScreen;
	}
	
	/**
	 * Method called when the first player picks {@code Rock}.
	 * @param event
	 */
	public void player1RockSelected(MouseEvent event) {
		System.out.println("Player 1 Rock Selected");
	}
	
	/**
	 * Method called when the first player picks {@code Paper}.
	 * @param event
	 */
	public void player1PaperSelected(MouseEvent event) {
		System.out.println("Player 1 Paper Selected");
	}
	
	/**
	 * Method called when the first player picks {@code Scissor}.
	 * @param event
	 */
	public void player1ScissorSelected(MouseEvent event) {
		System.out.println("Player 1 Scissor Selected");
	}
	
	/**
	 * Method called when the second player picks {@code Rock}.
	 * @param event
	 */
	public void player2RockSelected(MouseEvent event) {
		System.out.println("Player 2 Rock Selected");
	}
	
	/**
	 * Method called when the second player picks {@code Paper}.
	 * @param event
	 */
	public void player2PaperSelected(MouseEvent event) {
		System.out.println("Player 2 Paper Selected");
	}
	
	/**
	 * Method called when the second player picks {@code Scissor}.
	 * @param event
	 */
	public void player2ScissorSelected(MouseEvent event) {
		System.out.println("Player 2 Scissor Selected");
	}
	
	private void player1MadeDecision(GameObject decisionMade) {
		makeHBoxTransparent(player1HBox);
		player1Choice = decisionMade;
	}
	
	private void player2MadeDecision(GameObject decisionMade) {
		makeHBoxTransparent(player2HBox);
		player2Choice = decisionMade;
	}
	
	/**
	 * Method called when the reset button is clicked by
	 * the user.
	 * @param event
	 */
	public void resetButtonPressed(ActionEvent event) {
		resetGame();
	}
	
	/**
	 * Opens the first player's door.
	 */
	private void openPlayer1Door() {
		openPlayer1SlidingDoor.stop();
		resetPlayer1SlidingDoor();
		openPlayer1SlidingDoor.start();
	}
	
	/**
	 * Closes the first player's door.
	 */
	private void closePlayer1Door() {
		closePlayer1SlidingDoor.stop();
		closePlayer1SlidingDoor.start();
	}
	
	/**
	 * Opens the second player's door.
	 */
	private void openPlayer2Door() {
		openPlayer2SlidingDoor.stop();
		resetPlayer2SlidingDoor();
		openPlayer2SlidingDoor.start();
	}
	
	/**
	 * Closes the second player's door.
	 */
	private void closePlayer2Door() {
		closePlayer2SlidingDoor.stop();
		closePlayer2SlidingDoor.start();
	}
	
	/**
	 * Resets the first player's door. Back to its 
	 * closed position.
	 */
	private void resetPlayer1SlidingDoor() {
		player1SlidingDoor.setLayoutX(PLAYER1_CLOSED_SLIDING_DOOR_X);
	}
	
	/**
	 * Resets the second player's door. Back to its 
	 * closed position.
	 */
	private void resetPlayer2SlidingDoor() {
		player2SlidingDoor.setLayoutX(PLAYER2_CLOSED_SLIDING_DOOR_X);
	}
	
	/**
	 * Resets all the players' doors. Back to their original position.
	 */
	private void resetDoors() {
		resetPlayer1SlidingDoor();
		resetPlayer2SlidingDoor();
	}
	
	/**
	 * Method that takes the resulting message from the match and 
	 * displays it by making it opaque.
	 * @param resultMessage The message that resulted in who won or
	 * if it was a draw.
	 */
	private void showResultText(String resultMessage) {
		resultText.setText(resultMessage);
		resultText.setOpacity(1);
	}
	
	private void makeHBoxTransparent(HBox hBox) {
		hBox.setOpacity(.5);
		hBox.setMouseTransparent(true);
	}
	
	/**
	 * Resets the result text to not being opaque and containing
	 * empty text.
	 */
	private void resetResultText() {
		resultText.setOpacity(0);
		resultText.setText("");
	}
	
	private void resetPlayer1HBox() {
		player1HBox.setOpacity(1);
		player1HBox.setMouseTransparent(false);
	}
	
	private void resetPlayer2HBox() {
		player2HBox.setOpacity(1);
		player2HBox.setMouseTransparent(false);
	}
	
	private void resetHBoxes() {
		resetPlayer1HBox();
		resetPlayer2HBox();
	}
	
	/**
	 * Resets the game. Doors are closed and result
	 * text is hidden.
	 */
	private void resetGame() {
		resetDoors();
		resetResultText();
		resetHBoxes();
	}
	
	/**
	 * Method is called when the user presses the back button
	 * to return to the previous screen.
	 * @param event
	 */
	public void backButtonPressed(ActionEvent event) {
		RockPaperScissorMain.previousStage();
		resetGame();
	}
}
