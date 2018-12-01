package com.company;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class Traffic {

    ArrayList<Car> TrafficForward;
    ArrayList<Car> TrafficBackward;

    public Traffic(){
        TrafficForward = new ArrayList<Car>();
        TrafficBackward = new ArrayList<Car>();
    }

    public void add_Rect_Forward(Car car){
        TrafficForward.add(car);
    }

    public void add_Rect_Backward(Car car){
        TrafficBackward.add(car);
    }

    public void RemoveCar() {
        for (Car c:TrafficBackward) {
            if(c.checkDeletion()) {
                TrafficBackward.remove(c);
            }
        }
    }
}
