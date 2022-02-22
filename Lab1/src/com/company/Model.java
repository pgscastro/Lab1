package com.company;

/**
 * Author @Pedro Castro
 */



public class Model{
    public Model(){


    }

    /**
     * @param firstName
     * @param lastName
     * @param height
     * @param weight
     * @param canTravel
     * @param smokes
     */


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 3 && firstName.length() < 20){
            this.firstName = firstName;
        }else {
            this.firstName = " ";
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() >= 3 && lastName.length() <= 20) {
            this.lastName = lastName;
        } else {
            this.lastName = " ";
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 84 && height >= 24) {
            this.height = height;
        }else {
            this.height = 0;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight >= 80 && weight <= 280) {
        this.weight = weight;
        } else {
            this.weight = 0;
        }
    }

    public boolean isCanTravel() {
        return canTravel;
    }

    public void setCanTravel(boolean canTravel) {
        this.canTravel = canTravel;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    private String firstName;
    private  String lastName;
    private  int height;
    private  double weight;
    private boolean canTravel;
    private boolean smoke;
    public static final int INCHES_PER_FOOT = 12;
    public static final double POUNDS_PER_KG = 2.2046;
    public static final int BASE_RATE_DOLLARS_PER_HOUR = 60;
    public static final int TALL_INCHES = 67;
    public static final double THIN_POUNDS = 140.0;
    public static final int TALL_THIN_BONUS_DOLLARS_PER_HOUR = 5;
    public static final int TRAVEL_BONUS_DOLLARS_PER_HOUR = 4;
    public static final int SMOKER_DEDUCTION_DOLLARS_PER_HOUR = 10;





    public void printDetails() {

        System.out.println("Name: " + getFirstName() + " " + getLastName());
        System.out.println("Height: " + getHeight() + " cm");
        System.out.println("Weight: " + Math.round(getWeight()) + " Kgs");
        if (canTravel) {
            System.out.println("Does travel ");
        } else {
            System.out.println("Does not travel ");
        }
        if (smoke) {
            System.out.println("Does smoke ");
        } else {
            System.out.println("Does not smoke ");
        }
    }
    public String getHeightInFeetAndInches() {
        int feet = height / INCHES_PER_FOOT;
        int inches = height % INCHES_PER_FOOT;
        String result;
        if (inches == 0) {
            result = String.format("%d feet", feet);
        } else if (inches == 1) {
            result = String.format("%d feet and %d inch", feet, inches);
        } else {
            result = String.format("%d feet and %d inches", feet, inches);
        }
        return result;

    }
    public long getWeightKg() {
        long weightKg = (long) (POUNDS_PER_KG * weight);
        long result = Math.round(weightKg);
        return result;
    }
    public int calculatePayDollarsPerHour() {
        int bonus;
        int pay;
        boolean bodyBonus;
        if (height >= TALL_INCHES && weight < THIN_POUNDS) {
            bodyBonus = true;
        } else {
            bodyBonus = false;
        }

        if (canTravel && bodyBonus) {
            bonus = BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR + TRAVEL_BONUS_DOLLARS_PER_HOUR;
        } else if (canTravel && !bodyBonus) {
            bonus = BASE_RATE_DOLLARS_PER_HOUR + TRAVEL_BONUS_DOLLARS_PER_HOUR;
        } else if (!canTravel && bodyBonus) {
            bonus = BASE_RATE_DOLLARS_PER_HOUR + TALL_THIN_BONUS_DOLLARS_PER_HOUR;
        } else {
            bonus = BASE_RATE_DOLLARS_PER_HOUR;
        }

        if (smoke) {
            pay = bonus - SMOKER_DEDUCTION_DOLLARS_PER_HOUR;
        } else {
            pay = bonus;
        }

        return pay;

    }

    public void displayModelDetails(){
        String convertedHeight = getHeightInFeetAndInches();
        int payment = calculatePayDollarsPerHour();
        String sTravel;
        String sSmoke;
        if (canTravel){
            sTravel = "yes";
        } else {
            sTravel = "no";
        }

        if (smoke){
            sSmoke = "yes";
        } else {
            sSmoke = "no";
        }

        System.out.printf("Name: %s %s\nHeight: %s \nWeight: %.1f pounds\nTravels: %s\nSmokes: %s\nHourly rate: %d%n", getFirstName(), getLastName(), convertedHeight, getWeight(), sTravel, sSmoke, payment );
    }

}



