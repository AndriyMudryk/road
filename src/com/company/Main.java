package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {
    static volatile Traffic[] traffic;


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception evt) {}
        traffic = new Traffic[4];
        for(int i = 0; i < 4; ++i) {
            traffic[i] = new Traffic(i);
        }

        Thread thread_car = new Thread(){
            public void run() {
                while (true){
                    int p = new Random().nextInt(4);
                    traffic[p].add_Car_Forward(new Car(new Rectangle(20,180,20,20), p, 1));

                    try {
                        Thread.sleep(500);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
        };
        thread_car.start();
        // Create an instance of the test application
        int pixels = 918;
        Gui_field mainFrame = new Gui_field(pixels, traffic);
        mainFrame.pack();
        mainFrame.setSize(pixels,pixels + 20);
        mainFrame.setVisible( true );
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    mainFrame.test();
                }
            }
        };
        thread.start();
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("test");
	// write your code here
    }
}

