package com.company;

/**
 * Created by aleksandrakorolczuk1 on 2017-09-04.
 */



public class BikeShop {

    public static void main(String[] args) {

        int budget_richVanGuy = 9000;
        int budget_poorWhisGuy = 200;

        BikeFactory bikeFactory = new BikeFactory();

        Bike bike1 = bikeFactory.build(budget_richVanGuy);
        bike1.sell("Giant");

        Bike bike2 = bikeFactory.build(budget_poorWhisGuy);
        bike2.sell("Electra");

    }
}



