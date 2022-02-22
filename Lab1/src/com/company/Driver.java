package com.company;


public class Driver {

    public static void main(String[] args) {
        Model myself = new Model();
        myself.setFirstName("Pedro");
        myself.setLastName("Castro");
        myself.setSmoke(false);
        myself.setCanTravel(true);
        myself.setWeight(176);
        myself.setHeight(58);
        myself.printDetails();

        System.out.println(myself.getFirstName());
        System.out.println(myself.getLastName());
        System.out.println(myself.isSmoke());
        System.out.println(myself.isCanTravel());
        System.out.println(myself.getWeight());
        System.out.println(myself.getHeight());

        myself.displayModelDetails();


    }
}