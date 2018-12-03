package com.company;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Traffic extends Thread {
    int position;
    ArrayList<Car> TrafficForward;
    ArrayList<Car> TrafficBackward;

    public Traffic(int p) {
        TrafficForward = new ArrayList<Car>();
        TrafficBackward = new ArrayList<Car>();
        this.position = p;
    }

    public void add_Car_Forward(Car car) {
        TrafficForward.add(car);
    }

    public void add_Car_Backward(Car car) {
        TrafficBackward.add(car);
    }

    public void RemoveCar() {
        for (Car c : TrafficBackward) {
            if (c.checkDeletion()) {
                TrafficBackward.remove(c);
            }
        }
    }

    public Car SwitchRoad(Car c) {
        if (c.r.x > 270 && c.speed > 0) {
            if(this.position == 0) {
                c.r.x = 0;
            }
            if(this.position == 1) {
                c.r.y = 100;
            }
            if(this.position == 2) {
                c.r.y = 0;
                c.r.x = 100;
            }
            if(this.position == 3) {
                c.r.y = 270;
                c.r.x = 180;
            }
            TrafficForward.remove(c);
            return c;
        }
        return null;
    }
}
