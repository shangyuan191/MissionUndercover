package Room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import start_page.StartPage;

public class RoomUIController implements Initializable {
	@FXML
	private Label P1Name;
	@FXML
	private Label P1Des;
	@FXML
	private TextField chatRoomInput;
	@FXML
	private TextArea chatRoom;
	@FXML
	private TextField desInput;
	@FXML
	private Button desInputOK;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		System.out.println("initialize");
		// P1Name.setText("Charles");
		// P1Des.setText("灰色的");
		try {
			//Platform.runLater(new Runnable() {   //TODO: check if this can be used  if the   maybe solve the exception of the thread
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while (true) {
							chatRoom.setText(StartPage.player.getChatRoom());
						}
					} catch (Exception e) {
						System.out.println("RoomUIController error");
						;
					}
				}
			}).start();
		} catch (Exception e) {
			System.out.println("Error out UI");
		}
	}

	public void chatInput(ActionEvent e) throws IOException {
		System.out.println("ChatInput");
		String input = chatRoomInput.getText();
		// readline from system.in
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// print message to socket
		if (!input.equals("")) {
			chatRoomInput.setText("");
			StartPage.player.sendMessage("Chat:" + input);
		} else
			chatRoomInput.setText("");

		System.out.println("input : " + input);
	}

	public void desInput(ActionEvent e) {
		if (!desInput.getText().equals("")) {
			P1Des.setText(desInput.getText());
			desInput.setDisable(true);
			desInputOK.setDisable(true);
			desInput.setVisible(false);
			desInputOK.setVisible(false);
		}
	}

	public void goBackScene(ActionEvent event) throws IOException {
		/*
		 * for(Player i : players) { if(i.getName().equals("Charles")) {
		 * players.remove(i); // check if it is removed correctly break; } }
		 */
		System.out.println("go back");
		Parent root = FXMLLoader.load(getClass().getResource("/RoomChoice/RoomChoice.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		System.out.println("switch to scene RoomList");
	}

}