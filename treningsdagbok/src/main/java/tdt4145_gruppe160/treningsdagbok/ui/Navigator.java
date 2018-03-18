package tdt4145_gruppe160.treningsdagbok.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Navigator {
	
	public static final String APPARATUS_PANE = "Apparatus.FXML";
	
	private static MainController mainController;
	
	public static void setMainController(MainController mainController) {
		Navigator.mainController = mainController;
	}
	
	public static void loadPane(String fxml) {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(fxml));
		
		try {
			mainController.setContent((Node)loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
