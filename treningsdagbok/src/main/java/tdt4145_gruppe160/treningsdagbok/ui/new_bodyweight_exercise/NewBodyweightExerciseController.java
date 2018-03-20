package tdt4145_gruppe160.treningsdagbok.ui.new_bodyweight_exercise;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ApparatØvelse;
import tdt4145_gruppe160.treningsdagbok.core.ØvelsesGruppeCtrl.ØvelsesGruppe;

public class NewBodyweightExerciseController {
	
	@FXML private TextField nameField;
	@FXML private TextArea descriptionField;
	@FXML private ChoiceBox<String> groupField;
	@FXML private Label confirmationLabel;
	@FXML private VBox exerciseBox;
	
	public void initialize() {
		for(ØvelsesGruppe o: FxApp.dbHandler.getØvelsesGruppe()) {
			groupField.getItems().add(o.navn);
		}
		
		for(ApparatØvelse a : FxApp.dbHandler.getApparatØvelse()) {
			exerciseBox.getChildren().add(new Label(a.navn));
			exerciseBox.getChildren().add(new Separator());
		}
	}
	
	@FXML
	private void onSave() {
		if(FxApp.dbHandler.insertFriØvelse(nameField.getText(), groupField.getValue(), descriptionField.getText())) {
			confirmationLabel.setText("Bodyweight exercise successfully added");
			
			exerciseBox.getChildren().add(new Label(nameField.getText()));
			exerciseBox.getChildren().add(new Separator());
			
			nameField.clear();
			descriptionField.clear();
			
		} else {
			confirmationLabel.setText("Could not add exercise");
		}
	}
}
