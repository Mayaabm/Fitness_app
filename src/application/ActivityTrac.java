package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

public class ActivityTrac extends Application {
    public static String cardioCalories;
    public static String weightliftingCalories;
    private final Person person;

    public ActivityTrac() {
        this.person = new Person();
    }

    public ActivityTrac(Person person) {
        this.person = person;
    }

    public void start(Stage primaryStage) {
        Label l = new Label("Track your activity");
        l.getStyleClass().add("title"); 
        Label c = new Label("Track your cardio");
        c.getStyleClass().add("title2"); 

        Label Activity = new Label("cardio type:");
        ComboBox<String> act = new ComboBox<>();
        act.getItems().addAll(
                "Walking",
                "Running"
        );

        Label m = new Label("number of minutes");
        TextField min = new TextField();

        Label d = new Label("Distance(miles)");
        TextField dtc = new TextField();

        Label w = new Label("Track your weighlifting");
        w.getStyleClass().add("title"); 

        Label nbm = new Label("Number of minutes");
        TextField nbmin = new TextField();

        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> {
            String cardioMin = min.getText();
            String distnc = dtc.getText();
            String wlMin = nbmin.getText();

            float c_minFl = 0;
            float dtcFl = 0;
            float wl_minFl = 0;

            if (!cardioMin.isEmpty()) {
                c_minFl = Float.parseFloat(cardioMin);
            }

            if (!distnc.isEmpty()) {
                dtcFl = Float.parseFloat(distnc);
            }

            if (!wlMin.isEmpty()) {
                wl_minFl = Float.parseFloat(wlMin);
            }

            double minConv = CaloriesBurnt.convertToHours(wl_minFl);
            double weight = person.getWeight();
            double cardioCalories = 0;
            double weightliftingCalories = 0;

            if (!cardioMin.isEmpty() && !distnc.isEmpty()) {
                String activ = act.getValue();
                double mph = CaloriesBurnt.calcmph(minConv, dtcFl);
                double met = CaloriesBurnt.findMet(mph, activ);
                cardioCalories = CaloriesBurnt.calcCaloriesBurned(met, c_minFl, weight);
            }

            if (!wlMin.isEmpty()) {
                double met = CaloriesBurnt.findMet(0, "Weightlifting");
                weightliftingCalories = CaloriesBurnt.calcCaloriesBurned(met, wl_minFl, weight);
            }

            

            ActivityResults.cardioCalories = String.valueOf(cardioCalories);
            ActivityResults.weightliftingCalories = String.valueOf(weightliftingCalories);
            ActivityResults activityResults = new ActivityResults();
            activityResults.start(new Stage());
        });

        GridPane cardioSection = new GridPane();
        cardioSection.getStyleClass().add("custom-border");
        cardioSection.addRow(0, c);
        cardioSection.addRow(1, Activity, act);
        cardioSection.addRow(2, m, min);
        cardioSection.addRow(3, d, dtc);
        cardioSection.setVgap(5); 
        cardioSection.setPadding(new Insets(10)); 

        GridPane weightliftingSection = new GridPane();
        weightliftingSection.getStyleClass().add("custom-border");
        weightliftingSection.addRow(0, w);
        weightliftingSection.addRow(1, nbm, nbmin);
        weightliftingSection.setVgap(5); 
        weightliftingSection.setPadding(new Insets(10)); 
        VBox root2 = new VBox();
        root2.getChildren().addAll(l, cardioSection, weightliftingSection, calculateButton);
        root2.setSpacing(10);
        Scene scene2 = new Scene(root2);
        scene2.getStylesheets().add(getClass().getResource("TrackActivityStyle.css").toExternalForm());

        primaryStage.setTitle("Stronger");
        primaryStage.setScene(scene2);
        primaryStage.sizeToScene(); 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


