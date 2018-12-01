package com.company;

import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {

    public int x = 50;
    public int y = 50;
    int speed = 1;
    Traffic traffic;
    int direction;
    int id;

    public Road(Traffic rectangleList, int direction, int id){
        super();
        traffic = rectangleList;
        this.direction = direction;
        this.id = id;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(direction == 1) {
            System.out.println("1");
            g2.rotate(Math.toRadians(90), 150, 150);
        }
        if(direction == 2) {
            System.out.println("1");
            g2.rotate(Math.toRadians(180), 150, 150);
        }
        if(direction == 3) {
            System.out.println("1");
            g2.rotate(Math.toRadians(270), 150, 150);
        }
        for (Car c: traffic.TrafficForward) {
            if(this.id == c.position) {
                g2.setColor(Color.GREEN);
                g2.fill(c.get_Rect());
            }
        }
        for (Car c: traffic.TrafficBackward) {
            if(this.id == c.position) {
                g2.setColor(Color.GREEN);
                g2.fill(c.get_Rect());
            }
        }
    }
    public void moveForward(){
        for (Car c: traffic.TrafficForward) {
            c.checkSwitch();
            c.move();
        }

        try{
        Thread.sleep(1);}
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void moveBackward() {
        for (Car c:traffic.TrafficBackward) {
            c.move();
        }

        try{
            Thread.sleep(1);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
