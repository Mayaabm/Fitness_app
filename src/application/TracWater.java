package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TracWater extends Application {
    private final Person person;

    public TracWater(Person person) {
        this.person = person;
    }

    public void start(Stage primaryStage) {
        // Labels and text fields for entering water intake
        Label titleLabel = new Label("Track your water intake");
        Label waterLabel = new Label("Enter liters");
        TextField waterTextField = new TextField();

        // GridPane to organize water input elements
        GridPane waterGridPane = new GridPane();
        waterGridPane.addRow(0, waterLabel, waterTextField);
        waterGridPane.setHgap(10);
        waterGridPane.setVgap(10);

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> {
            double weight = person.getWeight();
            String activityLvl = person.getActivity();
            double intake = Double.parseDouble(waterTextField.getText());

            double waterIntakeNeeded = calcWater.calculateWaterIntakeNeeded(weight, activityLvl);
            person.setWaterIntakeNeeded(waterIntakeNeeded);

            intake = calcWater.adjustWaterIntake(intake);
            person.setWaterIntake(intake);
            
            double remainingIntakeNeeded = person.getWaterIntakeNeeded() - person.getWaterIntake();

            WaterResults waterResults = new WaterResults(person);
            waterResults.start(new Stage());

                    
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(titleLabel, waterGridPane, calculateButton);
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        Scene scene = new Scene(root, 400, 200);
        scene.getStylesheets().add(getClass().getResource("TrackWaterStyle.css").toExternalForm());

        primaryStage.setTitle("Track Water Intake");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void updateLabels(double intake, double waterIntakeNeeded, double remainingIntakeNeeded) {
        
        System.out.println("Intake: " + intake);
        System.out.println("Water Intake Needed: " + waterIntakeNeeded);
        System.out.println("Remaining Intake Needed: " + remainingIntakeNeeded);
    }

    
	

	public static void main(String[] args) {
        launch(args);
    }
}
