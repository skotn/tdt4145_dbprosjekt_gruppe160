package tdt4145_gruppe160.treningsdagbok.ui.new_equipment_exercise;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class NewEquipmentExerciseController {
	
	@FXML private TextField nameField;
	@FXML private ChoiceBox<String> equipmentField;
	@FXML private ChoiceBox<String> groupField;
	
	@FXML
	private void onSave() {
		//TODO Lagre ny apparatøvelse
		
		System.out.println("Saving new equipment exercise with name: " 
		+ nameField.getText() + ", equipment: " + equipmentField.getValue()
		+ ", group: " + groupField.getValue());
	}

}
