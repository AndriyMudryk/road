package com.company;
import javax.swing.*;
import java.awt.*;


public class Gui_field extends JFrame {
    private JPanel middle_panel;
    int pixels;

    private Road l_panel;
    private Road r_panel;
    private Road t_panel;
    private Road b_panel;

    private PedestrianRoad lt_pr;
    private PedestrianRoad rt_pr;
    private PedestrianRoad lb_pr;
    private PedestrianRoad rb_pr;

    private CircleCrossroad circleCrossroad;
    private Traffic traffic;

    public Gui_field(int pixels, Traffic traffic){
        this.pixels = pixels;
        this.traffic = traffic;

        setTitle( "Split Pane Application" );
        setBackground( Color.gray );
        setSize(pixels,pixels);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel top_left_panel = new JPanel();
        top_left_panel.setLayout( new GridLayout(3,3) );
        getContentPane().add( top_left_panel );

        // Create the panels
        create_l_panel(0);
        create_r_panel(1);
        create_t_panel(2);
        create_b_panel(3);
        create_pr();
        create_cr();
        // Create a splitter pane

        //splitPaneV = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        //topPanel.add( splitPaneV, BorderLayout.CENTER );

        //splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        /*
        JSplitPane js1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        top_left_panel.add(js1,BorderLayout.CENTER);
        */

        top_left_panel.add(lt_pr);
        top_left_panel.add(t_panel);
        top_left_panel.add(rt_pr);
        top_left_panel.add(l_panel);
        top_left_panel.add(circleCrossroad);
        top_left_panel.add(r_panel);
        top_left_panel.add(lb_pr);
        top_left_panel.add(b_panel);
        top_left_panel.add(rb_pr);

        //add(top_left_panel);

        /*
        js1.setDividerLocation(299);
        js1.setDividerSize(0);


        js1.setLeftComponent(l_panel);
        js1.setRightComponent(r_panel);
        */

        /*
        splitPaneH.setLeftComponent( l_panel );
        splitPaneH.setRightComponent( r_panel );

        splitPaneV.setLeftComponent( splitPaneH );
        splitPaneV.setRightComponent( t_panel );
        */
    }
    public void create_l_panel(int id){
        l_panel = new Road(traffic, 0, id);
        l_panel.setBackground(Color.red);
        // Add some buttons

    }

    public void create_r_panel(int id){
        r_panel = new Road(traffic, 2, id);
        r_panel.setBackground(Color.red);
    }
    public void test(){
        while (true)
        {

            l_panel.moveForward();
            r_panel.moveForward();
            t_panel.moveForward();
            b_panel.moveForward();
            l_panel.moveBackward();
            r_panel.moveBackward();
            t_panel.moveBackward();
            b_panel.moveBackward();
            l_panel.repaint();
            r_panel.repaint();
            t_panel.repaint();
            b_panel.repaint();
        }
    }

    public void create_t_panel(int id){
        t_panel = new Road(traffic, 1, id);
        t_panel.setBackground(Color.red);
    }
    public void create_b_panel(int id){
        b_panel = new Road(traffic, 3, id);
        b_panel.setBackground(Color.red);
    }

    public void create_pr(){
        lt_pr = new PedestrianRoad();
        rt_pr = new PedestrianRoad();
        lb_pr = new PedestrianRoad();
        rb_pr = new PedestrianRoad();
        lt_pr.setBackground(Color.CYAN);
        rt_pr.setBackground(Color.CYAN);
        lb_pr.setBackground(Color.CYAN);
        rb_pr.setBackground(Color.CYAN);
    }
    public void create_cr(){
        circleCrossroad = new CircleCrossroad();
        circleCrossroad.setBackground(Color.MAGENTA);
    }

}
