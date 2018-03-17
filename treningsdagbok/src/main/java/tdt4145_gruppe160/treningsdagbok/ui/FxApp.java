package tdt4145_gruppe160.treningsdagbok.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxApp extends Application {
	
	VBox mainLayout;
	
	@Override
	public void start(Stage arg0) throws Exception {
		Stage primaryStage = new Stage();
		primaryStage.setTitle("DB App");
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource("Menu.fxml"));
		try {
			mainLayout = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scene menuScene = new Scene(mainLayout);
		menuScene.getStylesheets().add(FxApp.class.getResource("style.css").toExternalForm());
		primaryStage.setScene(menuScene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
