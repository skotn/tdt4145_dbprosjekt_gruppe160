package tdt4145_gruppe160.treningsdagbok.ui.new_equipment_exercise;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import tdt4145_gruppe160.treningsdagbok.core.ØvelsesGruppeCtrl.ØvelsesGruppe;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;
import tdt4145_gruppe160.treningsdagbok.core.ApparatCtrl.Apparat;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.FriØvelse;

public class NewEquipmentExerciseController {
	
	@FXML private TextField nameField;
	@FXML private ChoiceBox<String> equipmentField;
	@FXML private ChoiceBox<String> groupField;
	@FXML private Label confirmationLabel;
	@FXML private VBox exerciseBox;
	
	public void initialize() {
		for(Apparat a : FxApp.dbHandler.getApparat()) {
			equipmentField.getItems().add(a.navn);
		}
		
		for(ØvelsesGruppe o: FxApp.dbHandler.getØvelsesGruppe()) {
			groupField.getItems().add(o.navn);
		}
		
		for(FriØvelse f : FxApp.dbHandler.getFriØvelse()) {
			exerciseBox.getChildren().add(new Label(f.navn));
			exerciseBox.getChildren().add(new Separator());
		}
	}
	
	@FXML
	private void onSave() {
		if(FxApp.dbHandler.insertApparatØvelse(nameField.getText(), groupField.getValue(), equipmentField.getValue())) {
			confirmationLabel.setText("Bodyweight exercise successfully added");
			
			exerciseBox.getChildren().add(new Label(nameField.getText()));
			exerciseBox.getChildren().add(new Separator());
			
			nameField.clear();
			
		} else {
			confirmationLabel.setText("Could not add exercise");
		}
	}

}
