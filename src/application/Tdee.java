package application;  
import javafx.scene.control.*;

public class Tdee {
   public RadioButton gender;		
   public TextField age;
   public TextField height;
   public TextField weight;
   public ComboBox<String> activity;
   public ComboBox<String> goal;
   public Tdee(){
   
   }
  public static double calcBmr(String gender,float age1,float height1,float weight1)
  {
	  double bmr=0;
	  if (gender.equalsIgnoreCase("male"))
		  bmr= 88.362 + (13.397 * weight1) + (4.799 *height1) - (5.677 * age1);
	  else if (gender.equalsIgnoreCase("female"))
		  bmr= 447.593 + (9.247 * weight1) + (3.098 * height1 ) - (4.330 * age1 );
	  return bmr;
  }
  public static double calcTdee( double bmr, String activity)
  {
	  double tdee=0;
	  double actFact=0;
	  if(activity.equalsIgnoreCase("Sedentary (Little or no exercise)"))
		  actFact=1.2;
	  else if (activity.equalsIgnoreCase("Lightly active (Exercise 1-3 days/week)"))  
		  actFact=1.375;
	  else if (activity.equalsIgnoreCase("Moderately active (Exercise 3-5 days/week)"))  
		  actFact=1.55;
	  else if (activity.equalsIgnoreCase("Very active (Exercise 6-7 days/week)"))  
		  actFact= 1.725;
	  tdee=bmr*actFact;
return tdee;
  }
  
  public static double adjustTdee(double tdee, String goal) {
	  double adjustedTdee=0;
	  if (goal.equalsIgnoreCase("Weight Loss"))
		  adjustedTdee=tdee-500;
	  else if (goal.equalsIgnoreCase("Weight Gain"))
		  adjustedTdee=tdee+500;
	  else if (goal.equalsIgnoreCase("Maintenance"))
		  adjustedTdee=tdee;
	  return adjustedTdee;
  }
  public static double protein(double result,String goal)
  {
	  double protein=0;
	  if (goal.equalsIgnoreCase("Weight Loss"))
		  protein= ((30 * result) / 100)/4;
	  else if (goal.equalsIgnoreCase("Weight gain"))
		  protein= ((25 * result) / 100)/4;
	  else if (goal.equalsIgnoreCase("maintenance"))
		 protein= ((30* result) / 100)/4;
	  return protein;
  }
  public static double carbs(double result,String goal)
  {
	  double carbs=0;
	  if (goal.equalsIgnoreCase("Weight Loss"))
		  carbs= ((40 * result) / 100)/4;
	  else if (goal.equalsIgnoreCase("Weight gain"))
		  carbs= ((50 * result) / 100)/4;
	  else if (goal.equalsIgnoreCase("maintenance"))
		 carbs= ((40* result) / 100)/4;
	  return carbs;
  }
  public static double fats(double result,String goal)
  {
	  double fats=0;
	  if (goal.equalsIgnoreCase("Weight Loss"))
		  fats= ((20 * result) / 100)/9;
	  else if (goal.equalsIgnoreCase("Weight gain"))
		  fats= ((25 * result) / 100)/9;
	  else if (goal.equalsIgnoreCase("maintenance"))
		 fats= ((30* result) / 100)/9;
	  return fats;
  }
  
  }
  
	


