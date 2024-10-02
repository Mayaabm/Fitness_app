package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WaterResults extends Application {
    private Person person;
    private Label currentIntakeLabel;
    private Label remainingIntakeLabel;

    public WaterResults(Person person) {
        this.person = person;
    }

    public void start(Stage stage) {
        currentIntakeLabel = new Label();
        remainingIntakeLabel = new Label();
        updateLabels();

        TextField intakeTextField = new TextField();
        intakeTextField.setPromptText("Enter water intake (Liters)");

        Button addButton = new Button("Add Water Intake");
        addButton.setOnAction(e -> {
            String intakeText = intakeTextField.getText();
            if (!intakeText.isEmpty()) {
                double newIntakeLiters = Double.parseDouble(intakeText);
                double newIntakeMilliliters = newIntakeLiters * 1000; // Convert to milliliters
                person.setWaterIntake(person.getWaterIntake() + newIntakeMilliliters); // Update in milliliters
                updateLabels();

                intakeTextField.clear();
            }
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(currentIntakeLabel, remainingIntakeLabel, intakeTextField, addButton);
        root.setPadding(new Insets(20));
        root.setSpacing(20);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);

        stage.setTitle("Water Intake Results");
        stage.show();
    }

    private void updateLabels() {
        double currentIntakeMilliliters = person.getWaterIntake();
        double remainingIntakeMilliliters = person.getWaterIntakeNeeded() - currentIntakeMilliliters;
        double currentIntakeLiters = currentIntakeMilliliters ; // Convert to liters
        double remainingIntakeLiters = remainingIntakeMilliliters / 1000; // Convert to liters
        
        if (remainingIntakeLiters <= 0) {
            currentIntakeLabel.setText("You've reached your daily water intake goal!");
            remainingIntakeLabel.setText("");
        } else {
            currentIntakeLabel.setText("Current water intake: " + currentIntakeLiters + " ml");
            remainingIntakeLabel.setText("Remaining water intake: " + remainingIntakeLiters + " Liters");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}



