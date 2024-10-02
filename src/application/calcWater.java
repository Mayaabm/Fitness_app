package application;
public class calcWater {
    public static double calculateWaterIntakeNeeded(double weight, String activityLevel) {
        double basalWaterIntake = weight * 30; 

        double additionalWater = 0;
        if (activityLevel.equals("Sedentary (Little or no exercise)")) {
            additionalWater += 0; 
        } else if (activityLevel.equals("Lightly active (Exercise 1-3 days/week)")) {
            additionalWater += 500; 
        } else if (activityLevel.equals("Moderately active (Exercise 3-5 days/week)")) {
            additionalWater += 1000;
        } else if (activityLevel.equals("Very active (Exercise 6-7 days/week)")) {
            additionalWater += 1500;
        }

        double totalWaterIntake = basalWaterIntake + additionalWater;
        return totalWaterIntake;
    }
    
    public static double adjustWaterIntake(double initialWaterIntake) {
        
        return initialWaterIntake;
    }
}


