package tdt4145_gruppe160.treningsdagbok.ui.new_bodyweight_exercise;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NewBodyweightExerciseController {
	
	@FXML private TextField nameField;
	@FXML private TextArea descriptionField;
	@FXML private ChoiceBox<String> groupField;
	
	@FXML
	private void onSave() {
		// TODO Implementer lagring av ny friøvelse til databasen
		
		System.out.println("Saving new bodyweight exercise with name: " 
	+ nameField.getText() 
	+ ", description: " + descriptionField.getText()
	+ ", group: " + groupField.getValue());
	}
	
}
