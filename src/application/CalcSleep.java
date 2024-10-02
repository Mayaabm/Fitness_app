package application;

public class CalcSleep {
	int hour;
	int minute;
	String amPm;
	  static int convertTo24Hour(int hour, int minute, String amPm) {
	        if (amPm.equals("PM") && hour != 12) {
	            hour += 12;
	        } else if (amPm.equals("AM") && hour == 12) {
	            hour = 0;
	        }
	        return hour * 60 + minute; }

	    static int calculateSleepDuration(int bedtime, int wakeupTime) {
	        int sleepDuration = wakeupTime - bedtime;
	        if (sleepDuration < 0) {
	            sleepDuration += 24 * 60;       }
	        return sleepDuration / 60; 
	    }

}
