package com.company;


import java.awt.*;
import java.util.ArrayList;
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

    public Car(Car c) {
        this.r = c.r;
        this.position = c.position;
        this.speed = c.speed;
    }

    public Rectangle get_Rect() {
        return this.r;
    }

    public void move() {
        this.r.x += speed;
    }


    public boolean checkDeletion() {
        return this.r.x < 0;
    }

    public int tryBackward() {
        if((r.x == 70 && r.y == 101 && position != 0) ||
                (r.x <= 181 && r.y == 70 && position != 3)||
                (r.x == 230 && r.y <= 70 && position != 1)||
                (r.x == 70 && r.y == 101 && position != 0)) {
            int rand = new Random().nextInt(3);
            System.out.println(r.x + " " + r.y + " " + rand + " " + position);
            if(rand == 1) {
                if(position + 1 == 3) {
                    return 0;
                } else {
                    return position + 1;
                }
            }else {
                return -1;
            }
        }
        return -1;
    }

    public int moveRound() {
        if(r.x == 70 && r.y > 170 && position != 0) {
            this.position = 0;
            return this.position;
        }
        if(r.y == 70 && r.x < 90 && position != 2) {
            this.position = 2;
            return this.position;
        }
        if(r.x == 230 && r.y < 120 && position != 1) {
            this.position = 1;
            return this.position;
        }
        if(r.y == 230 && r.x > 170 && position != 3) {
            this.position = 3;
            return this.position;
        }
        if(r.x < 70 || r.x > 230) {
            r.x += (r.x < 70)? speed: (-1) * speed;
        }
        else if(r.y < 70 || r.y > 230) {
            r.y += (r.y < 70)? speed: (-1) * speed;
        }

        else if(position == 0) {
            r.x += 1;
            r.y += 1;
        }
        else if(position == 1) {
            r.x += -1;
            r.y += -1;
        }
        else if(position == 2) {
            r.x += -1;
            r.y += 1;
        }
        else if(position == 3) {
            r.x += 1;
            r.y += -1;
        }
        return -1;
    }

    public void checkPosition(ArrayList<Car> trafficForward) {
        /*boolean b = true;
        for (Car c: trafficForward) {
            if (c != this && c.r.x < this.r.x + 21) {
                b = false;
            }
        }
        if(!b) {
            speed = 0;
        }
        else {
            speed = 1;
        }*/
    }

    public void hide() {
        this.r = new Rectangle(0,0,0,0);
    }
}
