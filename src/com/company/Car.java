package com.company;


import java.awt.*;
import java.util.Random;

public class Car {
    Rectangle r;
    int position;
    int speed;

    public Car(Rectangle r, int position, int speed) {
        this.r = r;
        this.position = position;
        this.speed = speed;
    }

    public Rectangle get_Rect() {
        return this.r;
    }

    public void move() {
        this.r.x += speed;
    }

    public void checkSwitch() {
        if(this.r.x > 280) {
            while (true) {
                int rand = new Random().nextInt(4);
                if(rand != position) {
                    position = rand;
                    break;
                }
            }
            this.speed = (-1) * this.speed;
            this.r.y = 50;
        }
    }

    public boolean checkDeletion() {
        return this.r.x < 0;
    }
}
