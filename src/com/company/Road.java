package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Road extends JPanel {

    public int x = 50;
    public int y = 50;
    int speed = 1;
    Traffic traffic;
    int direction;
    int id;
    CircleCrossroad cr;

    public Road(Traffic rectangleList, int direction, int id, CircleCrossroad cr){
        super();
        traffic = rectangleList;
        this.direction = direction;
        this.id = id;
        this.cr = cr;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        if(direction == 1) {
            //System.out.println("1");
            g2.rotate(Math.toRadians(90), 150, 150);
        }
        if(direction == 2) {
            //System.out.println("1");
            g2.rotate(Math.toRadians(180), 150, 150);
        }
        if(direction == 3) {
            //System.out.println("1");
            g2.rotate(Math.toRadians(270), 150, 150);
        }
        //g2d.setColor(Color.red);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src//road.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        g2.drawImage(img,0,0,this);
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
    public void move() {
        try {
                //traffic.SwitchRoad();
                for (Car c : traffic.TrafficForward) {
                    Car backwardCar = traffic.SwitchRoad(c);
                    if(backwardCar != null) {
                        cr.add(c);
                    }
                    c.checkPosition(traffic.TrafficForward);
                    //c.checkSpeed(traffic.TrafficForward);
                    c.move();
                }
                for (Car c : traffic.TrafficBackward) {
                    //c.checkSpeed(traffic.TrafficBackward);
                    c.move();
                }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Thread.sleep(1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
