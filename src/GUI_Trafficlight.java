public class GUI_Trafficlight {

    public int x;
    public int y;
    boolean green_light;

    GUI_Trafficlight(int global_x,int global_y){
        this.x = (global_x*50)+22;
        this.y = (global_y*50)+22;
        this.green_light = false;
    }
    GUI_Trafficlight(int line){
        this.green_light = false;
        switch (line){
            case 0:
                this.x = 150;
                this.y = 300;
                break;
            case 1:
                this.x = 450;
                this.y = 300;
                break;
            case 2:
                this.x = 300;
                this.y = 150;
                break;
            case 3:
                this.x = 300;
                this.y = 450;
                break;
        }
    }
}
