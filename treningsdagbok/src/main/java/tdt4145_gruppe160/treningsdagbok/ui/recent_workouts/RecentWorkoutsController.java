package tdt4145_gruppe160.treningsdagbok.ui.recent_workouts;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import tdt4145_gruppe160.treningsdagbok.ui.FxApp;

public class RecentWorkoutsController {
	
	@FXML private TextField nField;
	@FXML private ListView<String> listView;
	
	@FXML
	private void show() {
		try {
			int n = Integer.parseInt(nField.getText());
			
			listView.getItems().clear();
			
			FxApp.dbHandler.getNLastTreningsØkt(n).forEach(t -> {
				listView.getItems().add("#" + t.id + ", " + t.datoTid + ", " + t.varighet + " minutes, experience: " + t.opplevelse + ", form:" + t.personlig_form);
			});
				
		} catch(NumberFormatException e) {}
	}

}
