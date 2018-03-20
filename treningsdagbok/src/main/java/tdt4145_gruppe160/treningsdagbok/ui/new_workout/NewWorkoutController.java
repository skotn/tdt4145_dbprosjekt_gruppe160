package tdt4145_gruppe160.treningsdagbok.ui.new_workout;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NewWorkoutController {
	
	@FXML private DatePicker dateField;
	@FXML private TextField timeField;
	@FXML private TextField durationField;
	@FXML private TextField formField;
	@FXML private TextField performanceField;
	@FXML private TextField repetitionsField;
	@FXML private TextField setsField;
	@FXML private ChoiceBox<String> exerciseChoiceBox;
	
	@FXML private VBox exercises;
	
	public void initialize() {
		exerciseChoiceBox.getItems().addAll("Squats", "Swimming", "Run");
	}
	
	@FXML
	private void save() {
		// TODO Lagre ny treningsøkt til databasen
		
		System.out.println("Saving new workout with date: " 
		+ dateField.getValue() 
		+ ", time: " + timeField.getText()
		+ ", duration: " + durationField.getText()
		+ ", form: " + formField.getText()
		+ ", performance: " + performanceField.getText()
		);
		
		timeField.clear();
		durationField.clear();
		formField.clear();
		performanceField.clear();
		repetitionsField.clear();
		setsField.clear();
		
		exercises.getChildren().setAll();
	}
	
	@FXML
	private void addExercise() {
		exercises.getChildren().add(new Label(
				"repetitions: " + repetitionsField.getText()
				+ " sets: " + setsField.getText()
				));
		
		repetitionsField.clear();
		setsField.clear();
	}

}
