package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CircleCrossroad extends JPanel {
    public int x = 50;
    public int y = 50;
    public Rectangle rectangle = new Rectangle(x,y,50,50);
    ArrayList<Car> cars;

    Traffic[] tr;


    public CircleCrossroad(Traffic[] tr) {
        cars = new ArrayList<Car>();
        this.tr = tr;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src//Kolo.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        g2.drawImage(img,0,0,this);
        for(int i = 0; i < 4; ++i) {
            for (Car c : cars) {
                g2.setColor(Color.GREEN);
                g2.fill(c.get_Rect());
            }
        }
    }

    public void move() {
            for (Car c : cars) {
                int k = c.tryBackward();
                if (k != -1) {
                    System.out.println(k);
                    tr[k].TrafficBackward.add(new Car(c));
                    c.hide();
                }
                c.moveRound();
            }
    }

    public void add(Car c) {
        cars.add(c);
    }

}
