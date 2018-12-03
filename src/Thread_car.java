import java.util.ArrayList;

public class Thread_car extends Thread {
    private Field field;
    private boolean stop;

    public Thread_car(boolean stop,Field field){
        this.stop = stop;
        this.field = field;
    }
    public void stop_thread(){
        stop = false;
    }

    @Override
    public void run() {
        while (stop){
            Car temp = new Car(true,field);
            temp.start();
            field.getMainWindow().drawPanel.arrayListcar.add(temp);
            try {
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
