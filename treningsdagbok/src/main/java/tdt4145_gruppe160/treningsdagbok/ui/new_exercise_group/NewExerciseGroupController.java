package tdt4145_gruppe160.treningsdagbok.ui.new_exercise_group;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ApparatØvelse;
import tdt4145_gruppe160.treningsdagbok.core.ØvelsesGruppeCtrl.ØvelsesGruppe;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;

public class NewExerciseGroupController {
	
	@FXML private TextField nameField;
	@FXML private TextArea descriptionField;
	@FXML private Label confirmationLabel;
	@FXML private VBox groupBox;
	
	public void initialize() {
		for(ApparatØvelse a : FxApp.dbHandler.getApparatØvelse()) {
			groupBox.getChildren().add(new Label(a.navn));
			groupBox.getChildren().add(new Separator());
		}
	}
	
	@FXML private void onSave() {
		if(FxApp.dbHandler.insertØvelsesGruppe(nameField.getText(), descriptionField.getText())) {
			confirmationLabel.setText("Exercise group successfully added");
			
			groupBox.getChildren().add(new Label(nameField.getText()));
			groupBox.getChildren().add(new Separator());
			
			nameField.clear();
			descriptionField.clear();
		} else {
			confirmationLabel.setText("Could not add exercise group");
		}
	}
	
}
