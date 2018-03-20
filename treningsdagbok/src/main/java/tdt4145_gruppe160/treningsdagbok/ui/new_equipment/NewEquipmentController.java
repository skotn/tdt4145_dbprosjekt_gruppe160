package tdt4145_gruppe160.treningsdagbok.ui.new_equipment;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import tdt4145_gruppe160.treningsdagbok.core.ApparatCtrl.Apparat;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;

public class NewEquipmentController {
	
	@FXML private TextField nameField;
	@FXML private TextArea descriptionField;
	@FXML private Label confirmationLabel;
	@FXML private VBox equipmentBox;
	
	@FXML
	private void initialize() {
		
		for(Apparat a : FxApp.dbHandler.getApparat()) {
			equipmentBox.getChildren().add(new Label(a.navn));
			equipmentBox.getChildren().add(new Separator());
		}
		
	}
	
	@FXML
	private void onSave() {
		if(FxApp.dbHandler.insertApparat(nameField.getText(), descriptionField.getText())) {
			confirmationLabel.setText("New equipment added successfully.");
			
			equipmentBox.getChildren().add(new Label(nameField.getText()));
			equipmentBox.getChildren().add(new Separator());
			
			nameField.clear();
			descriptionField.clear();
		} else {
			confirmationLabel.setText("Could not add equpment.");
		}
		
	}

}
