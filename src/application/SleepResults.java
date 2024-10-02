package application;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SleepResults {
    private Person person;

    public SleepResults(Person person) {
        this.person = person;
    }

    public void start(Stage stage) {
        int sleepDuration = (int) person.getSleepDuration();
        String sleepFeedback;
        if (sleepDuration < 8 * 60) {
            sleepFeedback = "You slept less than 8 hours. This may lead to fatigue and reduced cognitive function.";
        } else if (sleepDuration == 8 * 60) {
            sleepFeedback = "You slept for 8 hours. Great job! This is the recommended amount of sleep for adults.";
        } else {
            sleepFeedback = "You slept more than 8 hours. Oversleeping can cause grogginess and may indicate an underlying health issue.";
        }

        Label resultsLabel = new Label("You have slept: " + sleepDuration + " hours");
        Label feedbackLabel = new Label(sleepFeedback);
	    feedbackLabel.setWrapText(true);

        VBox root = new VBox(10);
        root.getChildren().addAll(resultsLabel, feedbackLabel);

        Scene scene = new Scene(root, 400, 150);
        scene.getStylesheets().add(getClass().getResource("SleepResultsStyle.css").toExternalForm());

        stage.setScene(scene);

        stage.setTitle("Sleep Results");
        stage.show();
    }
}


