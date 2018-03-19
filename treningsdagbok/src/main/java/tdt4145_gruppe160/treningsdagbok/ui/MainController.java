package tdt4145_gruppe160.treningsdagbok.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class MainController {
	
	@FXML
	private AnchorPane anchorPane;
	
	public void onNewWorkout() {
		Navigator.loadPane(Navigator.NEW_WORKOUT_PANE);
	}
	
	@FXML
	private void onNewBodyeightExercise() {
		Navigator.loadPane(Navigator.NEW_BODYWEIGHT_EXERCISE_PANE);
	}
	
	@FXML
	private void onNewEquipmentExercise() {
		Navigator.loadPane(Navigator.NEW_EQUIPMENT_EXERCISE_PANE);
	}
	
	public void setContent(Node node) {
		anchorPane.getChildren().setAll(node);
	}
	
}
