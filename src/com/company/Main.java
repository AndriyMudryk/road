package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception evt) {}

        Traffic traffic = new Traffic();
        traffic.add_Rect_Forward(new Car(new Rectangle(20,250,20,20), 0, 2));
        traffic.add_Rect_Forward(new Car(new Rectangle(20,250,20,20), 1, 2));
        traffic.add_Rect_Forward(new Car(new Rectangle(20,250,20,20), 2, 2));
        traffic.add_Rect_Forward(new Car(new Rectangle(20,250,20,20), 3, 2));
        traffic.add_Rect_Forward(new Car(new Rectangle(20,250,20,20), 0, 1));
        traffic.add_Rect_Forward(new Car(new Rectangle(20,250,20,20), 1, 1));
        traffic.add_Rect_Forward(new Car(new Rectangle(20,250,20,20), 2, 1));

        //traffic.add_Rect_Backward(new Rectangle(20,50,20,20));
        // Create an instance of the test application
        int pixels = 900;
        Gui_field mainFrame = new Gui_field(pixels, traffic);
        mainFrame.pack();
        mainFrame.setSize(pixels,pixels);
        mainFrame.setVisible( true );
        mainFrame.test();

	// write your code here
    }
}

