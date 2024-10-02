package application;

import java.awt.Button;
import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Buttons extends Application{
    private Person person = new Person();

    public void start(Stage primaryStage) {
    	
    	
    	
    	 Label titleLabel = new Label("Stronger");
         titleLabel.getStyleClass().add("title"); 
         
         File file = new File("C:\\Users\\mayab\\OneDrive\\Desktop\\running.png");
         Image image = new Image(file.toURI().toString());

         HBox titleBox = new HBox(10);
         titleBox.setAlignment(Pos.CENTER_LEFT); 
         ImageView imageView = new ImageView(image);
         imageView.setFitWidth(40); 
         imageView.setFitHeight(40); 
         imageView.setPreserveRatio(true); 
         titleBox.getChildren().addAll(titleLabel, imageView);
         titleLabel.getStyleClass().add("title");

        Label genderLabel = new Label("Gender:  ");
        ToggleGroup group = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setToggleGroup(group);
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setToggleGroup(group);

        HBox genderBox = new HBox(10);
        genderBox.getChildren().addAll(genderLabel, maleRadioButton, femaleRadioButton);

        Label ageLabel = new Label("Age:   ");
        TextField ageTextField = new TextField();

        GridPane ageGridPane = new GridPane();
        ageGridPane.addRow(0, ageLabel, ageTextField);

        Label heightLabel = new Label("Height(cm):    ");
        TextField heightTextField = new TextField();

        GridPane heightGridPane = new GridPane();
        heightGridPane.addRow(0, heightLabel, heightTextField);

        Label weightLabel = new Label("Weight(kg):   ");
        TextField weightTextField = new TextField();

        GridPane weightGridPane = new GridPane();
        weightGridPane.addRow(0, weightLabel, weightTextField);

        Label activityLabel = new Label("Activity Level:  ");
        ComboBox<String> activityComboBox = new ComboBox<>();
        activityComboBox.getItems().addAll(
                "Sedentary (Little or no exercise)",
                "Lightly active (Exercise 1-3 days/week)",
                "Moderately active (Exercise 3-5 days/week)",
                "Very active (Exercise 6-7 days/week)"
        );

        Label goalLabel = new Label("Goal:");
        ComboBox<String> goalComboBox = new ComboBox<>();
        goalComboBox.getItems().addAll(
                "Weight Loss",
                "Maintenance",
                "Weight Gain"
        );

        Button calculateButton = new Button("Calculate TDEE");

         calculateButton.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
            String gender = selectedRadioButton.getText();
            String age = ageTextField.getText();
            String height = heightTextField.getText();
            String weight = weightTextField.getText();
            String activity = activityComboBox.getValue();
            String goal = goalComboBox.getValue();
            int ageInt = Integer.parseInt(age);
            float heightFloat = Float.parseFloat(height);
            float weightFloat = Float.parseFloat(weight);

            System.out.println(activity);

            double bmr = Tdee.calcBmr(gender, ageInt, heightFloat, weightFloat);
            double tdee = Tdee.calcTdee(bmr, activity);
            double results = Tdee.adjustTdee(tdee, goal);
            double protein = Tdee.protein(results, goal);
            double carbs = Tdee.carbs(results, goal);
            double fats = Tdee.fats(results, goal);

            person.setGender(gender);
            person.setAge(ageInt);
            person.setWeight(weightFloat);
            person.setHeight(heightFloat);
            person.setactivity(activity);
            person.setGoal(goal);
            person.setTdee(results);
            person.setProteinIntake(protein);
            person.setCarbsIntake(carbs);
            person.setFatIntake(fats);

            TdeeResultPage tdeeResultPage = new TdeeResultPage(person);
            tdeeResultPage.start(new Stage());
        });

        Button trackActivityButton = new Button("Track Your Activity");
       trackActivityButton.setOnAction(e -> {
            ActivityTrac activityTrac = new ActivityTrac(person);
            activityTrac.start(new Stage());
        });

        Button trackWaterButton = new Button("Track Your Water Intake");
        trackWaterButton.setOnAction(e -> {
            TracWater waterTrac = new TracWater(person);
            waterTrac.start(new Stage());
        });

        Button trackSleepButton = new Button("Track Your Sleep");
        ((ButtonBase) trackSleepButton).setOnAction(e -> {
            TracSleep sleepTrac = new TracSleep(person);
            sleepTrac.start(new Stage());
        });

        genderLabel.getStyleClass().add("label");
        maleRadioButton.getStyleClass().add("radio-button");
        femaleRadioButton.getStyleClass().add("radio-button");
        ageLabel.getStyleClass().add("label");
        ageTextField.getStyleClass().add("text-field");

    
        VBox dataEntryBox = new VBox(10);
        dataEntryBox.getStyleClass().add("data-entry-box"); 
        dataEntryBox.setAlignment(Pos.CENTER_RIGHT); 
        dataEntryBox.getChildren().addAll(
            genderBox,
            ageGridPane,
            heightGridPane,
            weightGridPane,
            new HBox(activityLabel, activityComboBox),
            new HBox(goalLabel, goalComboBox)
        );

        VBox items = new VBox(10);
        items.setAlignment(Pos.CENTER); 
        items.setPadding(new Insets(10)); 
        items.getChildren().addAll(
            calculateButton,
            trackActivityButton,
            trackWaterButton,
            trackSleepButton
        );



        VBox dataEntryContainer = new VBox();
        dataEntryContainer.setAlignment(Pos.CENTER_RIGHT);
        dataEntryContainer.getChildren().add(dataEntryBox);

   
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        root.getChildren().addAll(titleBox, dataEntryBox, items);

        Scene scene = new Scene(root, 800, 200);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        
    
        primaryStage.setTitle("Stronger"); 
        primaryStage.setScene(scene); 
        primaryStage.sizeToScene();
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}


