package application;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TracSleep extends Application {
    private final Person person;

    public TracSleep(Person person) {
        this.person = person;
    }

    public void start(Stage primaryStage) {
    	

   
        Label titleLabel = new Label("Track your sleep");
        titleLabel.setId("title-label");

        Label bedtimeLabel = new Label("Bedtime:");
        bedtimeLabel.setId("bedtime-label");

        Label hourLabel = new Label("Hour:");
        hourLabel.getStyleClass().add("input-label");

        Label minuteLabel = new Label("Minute:");
        minuteLabel.getStyleClass().add("input-label");

        Label amPmLabel = new Label("AM/PM:");
        amPmLabel.getStyleClass().add("input-label");

        ComboBox<Integer> hourComboBox = new ComboBox<>();
        hourComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ComboBox<Integer> minuteComboBox = new ComboBox<>();
        minuteComboBox.getItems().addAll(0, 15, 30, 45);
        ComboBox<String> amPmComboBox = new ComboBox<>();
        amPmComboBox.getItems().addAll("AM", "PM");

        Label wakeupLabel = new Label("Wakeup Time:");
        Label wHourLabel = new Label("Hour:");
        Label wMinuteLabel = new Label("Minute:");
        Label wAmPmLabel = new Label("AM/PM:");

        ComboBox<Integer> wHourComboBox = new ComboBox<>();
        wHourComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        ComboBox<Integer> wMinuteComboBox = new ComboBox<>();
        wMinuteComboBox.getItems().addAll(0, 15, 30, 45);
        ComboBox<String> wAmPmComboBox = new ComboBox<>();
        wAmPmComboBox.getItems().addAll("AM", "PM");

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> {
            int bedtimeHour = hourComboBox.getValue();
            int bedtimeMinute = minuteComboBox.getValue();
            String bedtimeAmPm = amPmComboBox.getValue();

            int wakeupHour = wHourComboBox.getValue();
            int wakeupMinute = wMinuteComboBox.getValue();
            String wakeupAmPm = wAmPmComboBox.getValue();

            int bedtime = CalcSleep.convertTo24Hour(bedtimeHour, bedtimeMinute, bedtimeAmPm);
            int wakeupTime = CalcSleep.convertTo24Hour(wakeupHour, wakeupMinute, wakeupAmPm);

            int sleepDuration = CalcSleep.calculateSleepDuration(bedtime, wakeupTime);
            person.setSleepDuration(sleepDuration);

            SleepResults sleepResults = new SleepResults(person);
            sleepResults.start(new Stage());
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(
            titleLabel,
            createSleepInputGrid(bedtimeLabel, hourLabel, hourComboBox, minuteLabel, minuteComboBox, amPmLabel, amPmComboBox),
            createSleepInputGrid(wakeupLabel, wHourLabel, wHourComboBox, wMinuteLabel, wMinuteComboBox, wAmPmLabel, wAmPmComboBox),
            calculateButton
        );
        root.setSpacing(20);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400, 250);
        scene.getStylesheets().add(getClass().getResource("TrackSleepStyle.css").toExternalForm());

        primaryStage.setTitle("Track Sleep");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane createSleepInputGrid(Label label1, Label label2, ComboBox<Integer> comboBox1, Label label3, ComboBox<Integer> comboBox2, Label label4, ComboBox<String> comboBox3) {
        GridPane grid = new GridPane();
        grid.add(label1, 0, 0);
        grid.add(label2, 0, 1);
        grid.add(comboBox1, 1, 1);
        grid.add(label3, 2, 1);
        grid.add(comboBox2, 3, 1);
        grid.add(label4, 4, 1);
        grid.add(comboBox3, 5, 1);
        return grid;
    }
    


    public static void main(String[] args) {
        launch(args);
    }
}

