package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ActivityResults extends Application {
    public static String cardioCalories;
    public static String weightliftingCalories;

    public void start(Stage primaryStage) {
        Label cardioLabel = new Label("Cardio Calories burned : " + cardioCalories);
        Label weightliftingLabel = new Label("Weightlifting Calories burned : " + weightliftingCalories);

        cardioLabel.getStyleClass().add("result-label");
        weightliftingLabel.getStyleClass().add("result-label");

        
        Label result=new Label(" Good Job Keep Going!!");
       result.getStyleClass().add("result-label");

        VBox layout = new VBox(10); 
        layout.getStyleClass().add("result-box"); 
        layout.getChildren().addAll(cardioLabel, weightliftingLabel, result);

        Scene scene = new Scene(layout, 300, 150); 
        scene.getStylesheets().add(getClass().getResource("ActivityResultsStyle.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Calories Burned Results");
        primaryStage.sizeToScene();

        primaryStage.setResizable(true); 
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


