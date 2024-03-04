package finalproject;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

enum TrafficLightColor {  
    RED, GREEN, YELLOW 
  } 
   
public class Stoplight extends VBox{
    protected Circle circletop; 
    protected Circle circleMid;
    protected Circle circleBottom;
    private TrafficLightColor tlc; // holds the current traffic light color 
    protected boolean stop = false; // set to true to stop the simulation 
    protected boolean changed = false;

    public Stoplight  (){
        tlc=TrafficLightColor.RED;
        buildUI();
    }
    
    private void buildUI() {
      //lightPane.setStyle("-fx-border-color: black; -fx-border-style: solid");
      //create light circles
      circletop = new Circle();
      circletop.setRadius(20);
      circletop.setStroke(Color.RED);
      circletop.setFill(Color.RED);
      circleMid = new Circle();
      circleMid.setRadius(20);
      circleMid.setFill(Color.WHITE);
      circleMid.setStroke(Color.YELLOW);  
      circleBottom = new Circle();
      circleBottom.setRadius(20);
      circleBottom.setFill(Color.WHITE);
      circleBottom.setStroke(Color.GREEN);
      getChildren().addAll(circletop, circleMid, circleBottom);
    }

  
    protected void invokeStoplightTask() {
      TrafficLightTask changeLight = new TrafficLightTask(this);
      Thread th = new Thread(changeLight);
      th.setDaemon(true);
      th.start();
    }

    // Change color. 
    synchronized void changeColor() { 
        switch(tlc) { 
        case RED: 
            tlc = TrafficLightColor.GREEN;
            break; 
        case YELLOW: 
            tlc = TrafficLightColor.RED; 
            break; 
        case GREEN: 
            tlc = TrafficLightColor.YELLOW;   
        } 
        changed = true;
        notify(); // signal that the light has changed 
    } 

    // Wait until a light change occurs. 
  synchronized void waitForChange() { 
    try { 
      while(!changed) 
        wait(); // wait for light to change 
      changed = false;
    } catch(InterruptedException exc) { 
      System.out.println(exc); 
    } 
  } 
    // Return current color. 
    synchronized TrafficLightColor getColor() { 
        return tlc; 
    } 
    
    // Stop the traffic light. 
    synchronized void cancel() { 
        stop = true; 
    } 
}

