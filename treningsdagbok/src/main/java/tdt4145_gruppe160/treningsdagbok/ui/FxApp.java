package tdt4145_gruppe160.treningsdagbok.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FxApp extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
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
		
		Scene mainScene = new Scene(mainPane);
		mainScene.getStylesheets().add(FxApp.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
