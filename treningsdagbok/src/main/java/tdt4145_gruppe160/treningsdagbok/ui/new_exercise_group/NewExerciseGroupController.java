package tdt4145_gruppe160.treningsdagbok.ui.new_exercise_group;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NewExerciseGroupController {
	
	@FXML private TextField nameField;
	@FXML private TextArea descriptionField;
	
	@FXML private void onSave() {
		//TODO Lagre øvelsesgruppe til databasen
		
		System.out.println("Saving new exercise group with name: " 
	+ nameField.getText() + ", description: " + descriptionField.getText());
	}
	
}
