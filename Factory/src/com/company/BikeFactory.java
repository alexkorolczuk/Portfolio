package com.company;

/**
 * Created by aleksandrakorolczuk1 on 2017-09-04.
 */


public class BikeFactory {

    public Bike build(int budget) {
        if (budget == 0)
            return null;
        if (budget > 0 && budget <=1000)
            return new RoadBike(budget);
        else if (budget > 1000 && budget < 10000)
            return new MountainBike(budget);

        return null;
    }
}



