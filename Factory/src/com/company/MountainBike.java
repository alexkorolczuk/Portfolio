package com.company;

/**
 * Created by aleksandrakorolczuk1 on 2017-09-04.
 */


public class MountainBike implements Bike {

    private int price;

    public MountainBike (int price) {
        this.price = price;
    }


    @Override
    public void sell(String brand) {
        System.out.println("Sold: mountain bike, frame brand: " + brand + " price: " + this.price + "CAD");

    }
}





