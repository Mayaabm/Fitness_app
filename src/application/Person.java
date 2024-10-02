package application;

public class Person {
  String gender;
  int age;
  double weight;
  double height;
  String activityLvl;
  String goal;
  double tdee;
  double proteinIntake;
  double fatIntake;
  double carbsIntake;
  double caloriesBurnt;
  double sleepDuration;
  double waterIntakeNeeded;
  double waterIntake;

  public Person() {
	  
  }
  
 public Person(String gender,int age,double weight,double height,String activityLvl,double tdee,double proteinIntake,double fatIntake,double carbsIntake,  double caloriesBurnt,double sleepDuration,double waterIntake) {
	 this.gender=gender;
	 this.age=age;
	 this.weight=weight;
	 this.height=height;
	 this.activityLvl=activityLvl;
	 this.tdee=tdee;
	 this.proteinIntake=proteinIntake;
	 this.fatIntake=fatIntake;
	 this.carbsIntake=carbsIntake;
	 this.caloriesBurnt=caloriesBurnt;
	 this.sleepDuration=sleepDuration;
	 this.waterIntake=waterIntake;
 }
 public void setGender(String gender) {
	 this.gender=gender;
 }
 public String getGender() {
     return gender;
 }
 public int getAge() {
     return age;
 }

 public void setAge(int age) {
     this.age = age;
 }

 public double getWeight() {
     return weight;
 }

 public void setWeight(double weight) {
     this.weight = weight;
 }

 public double getHeight() {
     return height;
 }

 public void setHeight(double height) {
     this.height = height;
 }
 public double getTdee() {
     return tdee;
 }

 public void setTdee(double tdee) {
     this.tdee = tdee;
 }

 public double getProteinIntake() {
     return proteinIntake;
 }

 public void setProteinIntake(double proteinIntake) {
     this.proteinIntake = proteinIntake;
 }

 public double getFatIntake() {
     return fatIntake;
 }

 public void setFatIntake(double fatIntake) {
     this.fatIntake = fatIntake;
 }

 public double getCarbsIntake() {
     return carbsIntake;
 }

 public void setCarbsIntake(double carbsIntake) {
     this.carbsIntake = carbsIntake;
 }

 
 public double getCaloriesBurnt() {
     return caloriesBurnt;
 }

 public void setCaloriesBurnt(double caloriesBurnt) {
     this.caloriesBurnt = caloriesBurnt;
 }

 
 public double getSleepDuration() {
     return sleepDuration;
 }

 public void setSleepDuration(double sleepDuration) {
     this.sleepDuration = sleepDuration;
 }

 
 public double getWaterIntakeNeeded() {
     return waterIntakeNeeded;
 }

 public void setWaterIntakeNeeded(double waterIntakeNeeded) {
     this.waterIntakeNeeded = waterIntakeNeeded;
 }
 public double getWaterIntake() {
     return waterIntake;
 }

 public double setWaterIntake(double waterIntake) {
     return this.waterIntake = waterIntake;
 }
 public String getActivity() {
     return activityLvl;
 }

 public void setactivity(String activityLvl) {
     this.activityLvl = activityLvl;
 }
 public String getGoal() {
	 return goal;
 }
 
 public void setGoal(String goal) {
	 this.goal=goal;
 }
}
 


