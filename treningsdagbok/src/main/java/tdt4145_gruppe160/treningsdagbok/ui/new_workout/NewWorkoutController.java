package tdt4145_gruppe160.treningsdagbok.ui.new_workout;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ØvelseTilRobert;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;

public class NewWorkoutController {
	
	class Exercise {
		String exercise;
		int weight;
		int sets;
		
		public Exercise(String exercise, int weight, int sets) {
			this.exercise = exercise;
			this.weight = weight;
			this.sets = sets;
		}
	}
	
	@FXML private DatePicker dateField;
	@FXML private TextField timeField;
	@FXML private TextField durationField;
	@FXML private TextField formField;
	@FXML private TextField performanceField;
	@FXML private TextField weightField;
	@FXML private TextField setsField;
	@FXML private ChoiceBox<String> exerciseChoiceBox;
	@FXML private TextArea objectiveField;
	@FXML private TextArea experienceField;
	@FXML private Label confirmationLabel;
	
	@FXML private VBox exercisesInBox;
	
	private ArrayList<Exercise> exercises;
	
	public void initialize() {
		for(ØvelseTilRobert e : FxApp.dbHandler.getØvelser()) {
			exerciseChoiceBox.getItems().add(e.navn);
		}
		
		exercises = new ArrayList<>();
	}
	
	@FXML
	private void save() {
		
		try {
			
			//---
			String dateTime = dateField.getValue() + " " + timeField.getText() + ":00";
			
			if(FxApp.dbHandler.insertTreningsØkt(dateTime, Integer.parseInt(durationField.getText()), Integer.parseInt(formField.getText()), Integer.parseInt(performanceField.getText()))) {
				for (Exercise e : exercises) {
					FxApp.dbHandler.insertØktØvelse(e.exercise, e.weight, e.sets);
				}
				
				if(!objectiveField.getText().isEmpty() || experienceField.getText().isEmpty()) {
					FxApp.dbHandler.insertNotat(objectiveField.getText(), experienceField.getText());
				}
				
				confirmationLabel.setText("New exercise added.");
				
				timeField.clear();
				durationField.clear();
				formField.clear();
				performanceField.clear();
				weightField.clear();
				setsField.clear();
				
				exercisesInBox.getChildren().setAll();
				
			} else {
				confirmationLabel.setText("Could not add exercise.");
			}
			//---
		} catch(NumberFormatException e) {
			confirmationLabel.setText("Could not add exercise.");
		}
		
	}
	
	@FXML
	private void addExercise() {
		try {
			int weight = Integer.parseInt(weightField.getText());
			int sets = Integer.parseInt(setsField.getText());
			
			exercises.add(new Exercise(exerciseChoiceBox.getValue(), weight, sets));
			
			exercisesInBox.getChildren().add(new Label(
					"weight: " + weight
					+ " sets: " + sets
					));
			
			weightField.clear();
			setsField.clear();
		} catch(NumberFormatException e) {
			System.out.println("nope");
		}
	}

}
