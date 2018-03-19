package tdt4145_gruppe160.treningsdagbok.ui.new_workout;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NewWorkoutController {
	
	@FXML private DatePicker dateField;
	@FXML private TextField timeField;
	@FXML private TextField durationField;
	@FXML private TextField formField;
	@FXML private TextField performanceField;
	
	public void onSave() {
		// TODO Lagre ny treningsøkt til databasen
		
		// Dette kan fjernes, det er bare så du ser hvordan man kan hente verdiene.
		System.out.println("Saving new workout with date: " 
		+ dateField.getValue() 
		+ ", time: " + timeField.getText()
		+ ", duration: " + durationField.getText()
		+ ", form: " + formField.getText()
		+ ", performance: " + performanceField.getText()
		);
		
		timeField.clear();
		durationField.clear();
		formField.clear();
		performanceField.clear();
	}

}
