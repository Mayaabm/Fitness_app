
package application;
public class CaloriesBurnt {
    public static double calcmph(double nbHours, float distance) {
        return distance / nbHours;
    }

    public static double findMet(double mph, String activity) {
        double Met = 0;
        if (activity.equalsIgnoreCase("Walking")) {
            if (mph >= 2.5 && mph <= 3.4)
                Met = 3.5;
            else if (mph >= 3.5 && mph <= 4.9)
                Met = 5.0;
            else if (mph >= 5.0 && mph <= 5.5)
                Met = 8.5;
        } else if (activity.equalsIgnoreCase("Running")) {
            if (mph >= 4.0 && mph <= 6.3)
                Met = 8.0;
            else if (mph >= 6.7 && mph <= 8.6)
                Met = 11.0;
            else if (mph >= 9.0 && mph <= 10.0)
                Met = 14.0;
            else if (mph >= 11.0 && mph <= 14.0)
                Met = 21.0;
        } else if (activity.equalsIgnoreCase("Weightlifting")) {
            Met = 5.0;
        }
        return Met;
    }

    public static double calcCaloriesBurned(double Met, double nbMin, double weight) {
        double caloriesBurnedPerMin = (Met * weight * nbMin) / 60 ; 
        return caloriesBurnedPerMin;
    }

    public static double convertToHours(float minutes) {
        return minutes / 60;
    }
}


