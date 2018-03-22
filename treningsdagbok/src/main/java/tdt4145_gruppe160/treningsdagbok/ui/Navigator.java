package tdt4145_gruppe160.treningsdagbok.ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Navigator {
	
	public static final String NEW_WORKOUT_PANE = "new_workout\\NewWorkout.fxml";
	public static final String NEW_BODYWEIGHT_EXERCISE_PANE = "new_bodyweight_exercise\\NewBodyweightExercise.fxml";
	public static final String NEW_EQUIPMENT_EXERCISE_PANE = "new_equipment_exercise\\NewEquipmentExercise.fxml";
	public static final String NEW_EXERCISE_GROUP_PANE = "new_exercise_group\\NewExerciseGroup.fxml";
	public static final String NEW_EQUIPMENT_PANE = "new_equipment\\NewEquipment.fxml";
	public static final String RECENT_WORKOUTS_PANE = "recent_workouts\\RecentWorkouts.fxml";
	public static final String RESULTS_PANE = "results\\Results.fxml";
	public static final String EXERCISES_BY_GROUP_PANE = "exercises_in_group\\ExercisesInGroup.fxml";
	
	private static MainController mainController;
	
	public static void setMainController(MainController mainController) {
		Navigator.mainController = mainController;
	}
	
	public static void loadPane(String fxml) {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(FxApp.class.getResource(fxml));
		
		try {
			mainController.setContent((Node)loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
