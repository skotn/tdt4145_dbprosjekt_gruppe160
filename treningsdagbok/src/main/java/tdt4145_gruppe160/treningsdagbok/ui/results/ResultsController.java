package tdt4145_gruppe160.treningsdagbok.ui.results;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ØvelseResultat;
import tdt4145_gruppe160.treningsdagbok.core.ØvelseCtrl.ØvelseTilRobert;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;

public class ResultsController {
	@FXML private DatePicker dateFrom;
	@FXML private DatePicker dateTo;
	@FXML private ChoiceBox<String> ovelseField;
	@FXML private VBox resultsBox;
	@FXML private Button fetch;
	
	public void initialize() {
		for(ØvelseTilRobert o: FxApp.dbHandler.getØvelser()) {
			ovelseField.getItems().add(o.navn);
		}	
	}

	@FXML
	private void viewResults() {
		resultsBox.getChildren().clear();
		String dateF = dateFrom.getValue() + "00:00:00";
		String dateT = dateTo.getValue() + "23:59:59";
		
		for(ØvelseResultat s : FxApp.dbHandler.getØvelseMedResultat(ovelseField.getValue(), dateF, dateT)) {
			resultsBox.getChildren().add(new Label(s.datoTid+" vekt: "+s.vekt+" sett: "+s.sett));
			resultsBox.getChildren().add(new Separator());
		}		
		
	}

}
