package start_page;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import Player.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class StartPage extends Application {
	public static Player player = new Player();

	@Override
	public void start(Stage primaryStage) {
		// use player.sendMessage to send command to server
		try {

			Parent root = FXMLLoader.load(getClass().getResource("StartPageFXML.fxml"));

			Scene scene = new Scene(root,600,600);
			scene.getStylesheets().add(getClass().getResource("StartPage.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		launch(args);
	}
}
