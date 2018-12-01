package com.company;

import javax.swing.*;
import java.awt.*;

public class PedestrianRoad extends JPanel {

    public int x = 50;
    public int y = 50;
    int x_dir = 1;
    public Rectangle rectangle = new Rectangle(x,y,50,50);

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GREEN);
        g2.fill(rectangle);
    }
    public void change(){
        rectangle.x += x_dir;
        rectangle.y += 0;
        if (rectangle.x > 250 || rectangle.x < 10){
            this.x_dir = -x_dir;
        }
        try{
            Thread.sleep(5);}
        catch (Exception e){
            System.out.println(e);
        }
    }
}
