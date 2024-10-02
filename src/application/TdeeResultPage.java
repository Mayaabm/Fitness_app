package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TdeeResultPage extends Application {
    private Person person;

    public TdeeResultPage(Person person) {
        this.person = person;
    }

    @Override
  
    	public void start(Stage primaryStage) {
    	    double totalCalories = person.getTdee();
    	    double proteinPercentage = (person.getProteinIntake() * 4) / totalCalories * 100;
    	    double fatsPercentage = (person.getFatIntake() * 9) / totalCalories * 100;
    	    double carbsPercentage = (person.getCarbsIntake() * 4) / totalCalories * 100;

    	    PieChart.Data proteinData = new PieChart.Data("Protein", proteinPercentage);
    	    PieChart.Data fatsData = new PieChart.Data("Fats", fatsPercentage);
    	    PieChart.Data carbsData = new PieChart.Data("Carbs", carbsPercentage);

    	    PieChart pieChart = new PieChart();
    	    pieChart.setId("pieChart");
    	    pieChart.getData().addAll(proteinData, fatsData, carbsData);
    	    pieChart.setTitle("Macronutrient Distribution");

    	  
    	    Label results = new Label("Your " + person.getGoal() + " calories are: " + (int)person.getTdee()+ "kcal");
    	    results.getStyleClass().add("label");
    	    Label pLabel = new Label("Macrunutrient distribution needed to sustain your "+person.getGoal()+" : ");
    	    pLabel.getStyleClass().add("label");
    	    pLabel.setWrapText(true);
    	    Label proteinLabel = new Label("Protein: " + (int)person.getProteinIntake() + "g");
    	    proteinLabel.getStyleClass().add("label");
    	    Label fatsLabel = new Label("Fats: " + (int)person.getFatIntake() + "g");
    	    fatsLabel.getStyleClass().add("label");
    	    Label carbsLabel = new Label("Carbs: " + (int)person.getCarbsIntake() + "g");
    	    carbsLabel.getStyleClass().add("label");

    	    VBox labelsVBox = new VBox();
    	    labelsVBox.getChildren().addAll(results, pLabel, proteinLabel, fatsLabel, carbsLabel);
    	    labelsVBox.getStyleClass().add("labels-vbox");

    	    HBox root = new HBox();
    	    root.getChildren().addAll(labelsVBox, pieChart);
    	    root.getStyleClass().add("root");

    	    Scene scene = new Scene(root, 800, 400);
    	    scene.getStylesheets().add(getClass().getResource("Tdeestyle.css").toExternalForm()); // Load CSS file
    	    primaryStage.setScene(scene);
    	    primaryStage.setTitle("TDEE Result");
    	    primaryStage.show();
    	}


    public static void main(String[] args) {
        // Create a Person object with required data
        Person person = new Person(/* provide required data */);

        // Launch the application
        launch(args);
    }
}

