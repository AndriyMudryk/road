import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public DrawPanel drawPanel;

    public MainWindow() {
        initUI();
        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    drawPanel.repaint();
                    try{
                        Thread.sleep(20);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }
            }
        };
        thread.start();


    }

    private void initUI() {
        drawPanel = new DrawPanel();
        add(drawPanel);
        setSize(600, 640);
        setTitle("Points");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
