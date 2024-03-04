package finalproject;

import javafx.concurrent.Task;
import javafx.scene.paint.Color;

public class TrafficLightTask extends Task{
    Stoplight light;
    public TrafficLightTask(Stoplight light){
        this.light= light;  
    }

    @Override
    protected TrafficLightColor call() throws Exception {
        while(!light.stop) { 
                    try { 
                    switch(light.getColor()) { 
                        case GREEN: 
                        Thread.sleep(10000); 
                        light.circleMid.setFill(Color.YELLOW); 
                        light.circleBottom.setFill(Color.WHITE);  // green for 10 seconds 
                        break; 
                        case YELLOW: 
                        Thread.sleep(2000);
                        light.circleMid.setFill(Color.WHITE);
                        light.circletop.setFill(Color.RED);  
                            // yellow for 2 seconds 
                        break; 
                        case RED: 
                        Thread.sleep(12000); // red for 12 seconds 
                        light.circletop.setFill(Color.WHITE);
                        light.circleBottom.setFill(Color.GREEN); 
                        break; 
                    } 
                    } catch(InterruptedException exc) { 
                    System.out.println(exc); 
                    } 
                light.changeColor(); 
                }  
        return light.getColor();
    }

}
