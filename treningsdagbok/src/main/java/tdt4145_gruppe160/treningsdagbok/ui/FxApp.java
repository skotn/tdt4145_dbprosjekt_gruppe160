package tdt4145_gruppe160.treningsdagbok.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tdt4145_gruppe160.treningsdagbok.core.DatabaseHandler;

public class FxApp extends Application {
	
	public static DatabaseHandler dbHandler;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		dbHandler = new DatabaseHandler();
		dbHandler.connectToDatabase();
		
		primaryStage.setTitle("DB App");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("Main.fxml"));
		Pane mainPane = null;
		try {
			mainPane = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		MainController mainController = loader.getController();

        Navigator.setMainController(mainController);
		
		Scene mainScene = new Scene(mainPane, 640, 640);
		mainScene.getStylesheets().add(FxApp.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(mainScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
