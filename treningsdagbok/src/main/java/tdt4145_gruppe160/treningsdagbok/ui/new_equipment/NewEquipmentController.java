package tdt4145_gruppe160.treningsdagbok.ui.new_equipment;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class NewEquipmentController {
	
	@FXML private TextArea descriptionField;
	
	@FXML
	private void onSave() {
		System.out.println("Saving equipment with description: " + descriptionField.getText());
		
		descriptionField.clear();
	}

}
