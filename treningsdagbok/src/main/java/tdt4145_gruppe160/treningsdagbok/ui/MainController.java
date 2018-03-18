package tdt4145_gruppe160.treningsdagbok.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class MainController {
	
	@FXML
	private AnchorPane anchorPane;
	
	public void onItemClick() {
		Navigator.loadPane(Navigator.APPARATUS_PANE);
	}
	
	public void setContent(Node node) {
		anchorPane.getChildren().setAll(node);
	}
	
}
