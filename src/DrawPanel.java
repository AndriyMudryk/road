import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class DrawPanel extends JPanel {
    int x = 312,y=312,velX = 25,velY = 25;

    ArrayList<Car> arrayListcar;
    ArrayList<Pedestrian> arrayListpedestrian;
    ArrayList<GUI_Trafficlight> arrayListlight;
    /*
    private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        //g2d.setColor(Color.red);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src//backmap.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        g2d.drawImage(img,0,0,this);

        g2d.setColor(Color.RED);
        //g2d.fillRect(x,y,25,25);
        if (arrayList.size() > 0) {
            for (Car c : arrayList) {
                g2d.fillRect(c.gui_car.X(), c.gui_car.Y(), 20, 20);
            }
        }

    }
    */
    public DrawPanel(){
        super();
        arrayListcar = new ArrayList<Car>();
        arrayListpedestrian = new ArrayList<Pedestrian>();
        arrayListlight = new ArrayList<GUI_Trafficlight>();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //g2d.setColor(Color.red);
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src//backmap.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
        g2d.drawImage(img,0,0,this);

        g2d.setColor(Color.CYAN);
        //g2d.fillRect(x,y,25,25);
        if (arrayListcar.size() > 0) {
            for (Car c : arrayListcar) {
                g2d.fillRect(c.gui_car.X(), c.gui_car.Y(), 20, 20);
            }
        }
        g2d.setColor(Color.blue);
        if (arrayListpedestrian.size() > 0) {
            for (Pedestrian p : arrayListpedestrian) {
                g2d.fillRect(p.gui_pedestrian.X(), p.gui_pedestrian.Y(), 5, 5);
            }
        }
        if (arrayListlight.size() > 0) {
            for (GUI_Trafficlight p : arrayListlight) {
                if (p.green_light){
                    g2d.setColor(Color.GREEN);
                }
                else { g2d.setColor(Color.RED);}
                g2d.fillRect(p.x, p.y, 10, 10);
            }
        }


    }

    public void actionPerformed(ActiveEvent e){
        x += velX;
        repaint();
    }


}
