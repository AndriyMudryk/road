import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI_Car extends JPanel {
    private int x;
    private int y;

    private int global_x;
    private int global_y;

    public GUI_Car(int x,int y){
        System.out.println("GUI CAR CREATE");
        this.global_x = x;
        this.global_y = y;
        this.x = (x*50) + 25;
        this.y = (y*50) + 25;
        System.out.println(this.x+"=="+this.y);
    }
    public void rotate(){
        System.out.println("rotate");
    }
    public void get_next(int x,int y){
        if (this.global_x == x){
            global_y = y;
            for (int i = 0;i<50;i++){
                this.y += (this.y > ((y*50) + 25))?-1:1;
                try{
                    Thread.sleep(10);
                } catch (Exception e){}
            }
        }
        else{
            global_x = x;
            for (int i = 0;i<50;i++){
                this.x += (this.x> ((x*50) + 25))?-1:1;
                try{
                    Thread.sleep(10);
                } catch (Exception e){}
            }
        }

        //System.out.println("done next");
    }

    private void doDrawing(Graphics g) {
        //g2d.setColor(Color.red);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle r = new Rectangle(x-25,y-25,25,25);
        g2.setColor(Color.blue);
        g2.fill(r);

    }
    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        System.out.println("start graphics car");
        doDrawing(g);
    }

    public int X() {
        return x;
    }

    public void X(int x) {
        this.x = x;
    }

    public int Y() {
        return y;
    }

    public void Y(int y) {
        this.y = y;
    }
}
