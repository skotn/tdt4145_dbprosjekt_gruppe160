package tdt4145_gruppe160.treningsdagbok.ui.exercises_in_group;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import tdt4145_gruppe160.treningsdagbok.core.ØvelsesGruppeCtrl.ØvelsesGruppe;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;

public class ExercisesInGroupController {
	
	@FXML private ChoiceBox<String> groupField;
	@FXML private VBox exercisesBox;
	
	public void initialize() {
		for(ØvelsesGruppe o: FxApp.dbHandler.getØvelsesGruppe()) {
			groupField.getItems().add(o.navn);
		}
		
		groupField.setOnAction(e -> {
			exercisesBox.getChildren().clear();
			
			for(String s : FxApp.dbHandler.getØvelserIGruppe(groupField.getValue())) {
				exercisesBox.getChildren().add(new Label(s));
				exercisesBox.getChildren().add(new Separator());
			}
		});
	}
}
