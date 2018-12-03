public class Traffic_lights extends Thread{

    private boolean stop;
    private Field field;
    private int n_fields;

    GUI_Trafficlight[] car_light;
    GUI_Trafficlight[] ped_light;

    public Traffic_lights(boolean stop,Field field){
        n_fields = field.getN_fields();
        this.stop = stop;
        this.field = field;
        car_light = new GUI_Trafficlight[8];
        ped_light = new GUI_Trafficlight[4];
        set_light();


    }
    public void stop_light(){
        this.stop = false;
    }
    private void iteration_1(){
        field.set_redlight_car(n_fields+2,n_fields);
        field.set_redlight_car(n_fields+4,n_fields+5);

        car_light[5].green_light = false;
        car_light[7].green_light = false;

        field.set_redlight_ped(n_fields,n_fields+1);
        field.set_redlight_ped(n_fields,n_fields+2);
        field.set_redlight_ped(n_fields,n_fields+3);
        field.set_redlight_ped(n_fields,n_fields+4);

        ped_light[0].green_light = false;

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }

        field.set_greenlight_car(n_fields,n_fields+3);
        field.set_greenlight_car(n_fields+5,n_fields+1);

        car_light[0].green_light = true;
        car_light[2].green_light = true;

        field.set_greenlight_ped(n_fields+1,n_fields+5);
        field.set_greenlight_ped(n_fields+2,n_fields+5);
        field.set_greenlight_ped(n_fields+3,n_fields+5);
        field.set_greenlight_ped(n_fields+4,n_fields+5);

        ped_light[3].green_light = true;
    }
    private void iteration_2(){
        field.set_redlight_car(n_fields,n_fields+3);
        field.set_redlight_car(n_fields+5,n_fields+1);

        car_light[0].green_light = false;
        car_light[2].green_light = false;

        field.set_redlight_ped(n_fields+1,n_fields+5);
        field.set_redlight_ped(n_fields+2,n_fields+5);
        field.set_redlight_ped(n_fields+3,n_fields+5);
        field.set_redlight_ped(n_fields+4,n_fields+5);

        ped_light[3].green_light = false;
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }


        field.set_greenlight_car(n_fields+3,n_fields+5);
        field.set_greenlight_car(n_fields+1,n_fields);

        car_light[6].green_light = true;
        car_light[4].green_light = true;

        field.set_greenlight_ped(n_fields+5,n_fields+1);
        field.set_greenlight_ped(n_fields+5,n_fields+2);
        field.set_greenlight_ped(n_fields+5,n_fields+3);
        field.set_greenlight_ped(n_fields+5,n_fields+4);

        ped_light[1].green_light = true;

    }
    private void iteration_3(){
        field.set_redlight_car(n_fields+3,n_fields+5);
        field.set_redlight_car(n_fields+1,n_fields);

        car_light[6].green_light = false;
        car_light[4].green_light = false;

        field.set_redlight_ped(n_fields+5,n_fields+1);
        field.set_redlight_ped(n_fields+5,n_fields+2);
        field.set_redlight_ped(n_fields+5,n_fields+3);
        field.set_redlight_ped(n_fields+5,n_fields+4);

        ped_light[1].green_light = false;

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }

        field.set_greenlight_car(n_fields+5,n_fields+2);
        field.set_greenlight_car(n_fields,n_fields+4);

        car_light[3].green_light = true;
        car_light[1].green_light = true;

        field.set_greenlight_ped(n_fields+1,n_fields);
        field.set_greenlight_ped(n_fields+2,n_fields);
        field.set_greenlight_ped(n_fields+3,n_fields);
        field.set_greenlight_ped(n_fields+4,n_fields);

        ped_light[2].green_light = true;
    }
    private void iteration_4(){
        field.set_redlight_car(n_fields+5,n_fields+2);
        field.set_redlight_car(n_fields,n_fields+4);

        car_light[3].green_light = false;
        car_light[1].green_light = false;

        field.set_redlight_ped(n_fields+1,n_fields);
        field.set_redlight_ped(n_fields+2,n_fields);
        field.set_redlight_ped(n_fields+3,n_fields);
        field.set_redlight_ped(n_fields+4,n_fields);

        ped_light[2].green_light = false;

        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e);
        }

        field.set_greenlight_car(n_fields+2,n_fields);
        field.set_greenlight_car(n_fields+4,n_fields+5);

        car_light[5].green_light = true;
        car_light[7].green_light = true;

        field.set_greenlight_ped(n_fields,n_fields+1);
        field.set_greenlight_ped(n_fields,n_fields+2);
        field.set_greenlight_ped(n_fields,n_fields+3);
        field.set_greenlight_ped(n_fields,n_fields+4);

        ped_light[0].green_light = true;
    }

    public void set_light(){
        field.set_redlight_car(n_fields,n_fields+3);
        field.set_redlight_car(n_fields,n_fields+4);

        car_light[0] = new GUI_Trafficlight(n_fields,n_fields+3);
        car_light[1] = new GUI_Trafficlight(n_fields,n_fields+4);

        field.getMainWindow().drawPanel.arrayListlight.add(car_light[0]);
        field.getMainWindow().drawPanel.arrayListlight.add(car_light[1]);
        //=======================================================

        field.set_redlight_car(n_fields+5,n_fields+1);
        field.set_redlight_car(n_fields+5,n_fields+2);

        car_light[2] = new GUI_Trafficlight(n_fields+5,n_fields+1);
        car_light[3] = new GUI_Trafficlight(n_fields+5,n_fields+2);

        field.getMainWindow().drawPanel.arrayListlight.add(car_light[2]);
        field.getMainWindow().drawPanel.arrayListlight.add(car_light[3]);
        //======================================================

        field.set_redlight_car(n_fields+1,n_fields);
        field.set_redlight_car(n_fields+2,n_fields);

        car_light[4] = new GUI_Trafficlight(n_fields+1,n_fields);
        car_light[5] = new GUI_Trafficlight(n_fields+2,n_fields);

        field.getMainWindow().drawPanel.arrayListlight.add(car_light[4]);
        field.getMainWindow().drawPanel.arrayListlight.add(car_light[5]);
        //======================================================

        field.set_redlight_car(n_fields+3,n_fields+5);
        field.set_redlight_car(n_fields+4,n_fields+5);

        car_light[6] = new GUI_Trafficlight(n_fields+3,n_fields+5);
        car_light[7] = new GUI_Trafficlight(n_fields+4,n_fields+5);

        field.getMainWindow().drawPanel.arrayListlight.add(car_light[6]);
        field.getMainWindow().drawPanel.arrayListlight.add(car_light[7]);
        //======================================================

        field.set_redlight_ped(n_fields,n_fields+1);
        field.set_redlight_ped(n_fields,n_fields+2);
        field.set_redlight_ped(n_fields,n_fields+3);
        field.set_redlight_ped(n_fields,n_fields+4);

        ped_light[0] = new GUI_Trafficlight(0);
        field.getMainWindow().drawPanel.arrayListlight.add(ped_light[0]);

        field.set_redlight_ped(n_fields+5,n_fields+1);
        field.set_redlight_ped(n_fields+5,n_fields+2);
        field.set_redlight_ped(n_fields+5,n_fields+3);
        field.set_redlight_ped(n_fields+5,n_fields+4);

        ped_light[1] = new GUI_Trafficlight(1);
        field.getMainWindow().drawPanel.arrayListlight.add(ped_light[1]);

        field.set_redlight_ped(n_fields+1,n_fields);
        field.set_redlight_ped(n_fields+2,n_fields);
        field.set_redlight_ped(n_fields+3,n_fields);
        field.set_redlight_ped(n_fields+4,n_fields);

        ped_light[2] = new GUI_Trafficlight(2);
        field.getMainWindow().drawPanel.arrayListlight.add(ped_light[2]);

        field.set_redlight_ped(n_fields+1,n_fields+5);
        field.set_redlight_ped(n_fields+2,n_fields+5);
        field.set_redlight_ped(n_fields+3,n_fields+5);
        field.set_redlight_ped(n_fields+4,n_fields+5);

        ped_light[3] = new GUI_Trafficlight(3);
        field.getMainWindow().drawPanel.arrayListlight.add(ped_light[3]);
    }
    @Override
    public void run() {
        System.out.println("Traffic lights on");
        while (this.stop){
            System.out.println("It 1");
            iteration_1();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("It 2");
            iteration_2();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("It 3");
            iteration_3();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.println("It 4");
            iteration_4();
            try {
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Traffic lights off");
    }
}
