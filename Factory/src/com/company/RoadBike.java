package com.company;

/**
 * Created by aleksandrakorolczuk1 on 2017-09-04.
 */


public class RoadBike implements Bike {

    private int price;

    public RoadBike (int price) {
        this.price = price;
    }

    public void sell(String brand) {
        System.out.println("Sold: road bike, frame brand: " + brand + " price: " + this.price + "CAD");

    }
}






