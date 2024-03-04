package finalproject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

enum CarColor{
    RED, GREEN, BLUE, YELLOW, ORANGE
}

public class Vehicle 
{
    private static final List<CarColor> VALUES =
    Collections.unmodifiableList(Arrays.asList(CarColor.values()));
    private static final Random RANDOM = new Random();
    private static final int SIZE = VALUES.size();
    private float xPos;
    private float yPos;
    private final int HEIGHT = 15; 
    private final int WIDTH = 20;
    protected double speed;
    
    public Vehicle(float xPos, float yPos, double speed){
        this.xPos = xPos;
        this.yPos = yPos;
        this.speed = speed;
        paintCar();
    }
    
    public Double getSpeed(){
        return speed;
    }
    
    public float getX(){
        return xPos;
    } 

    public float  getY(){
        return yPos;
    }

    public void setSpeed(double speed){
        this.speed =speed; 
    }
    public void setX(float x){
        this.xPos = x;
    }
    public void setY(float y){
        this.yPos = y;
    }
    
    public static Color randomColor(){
        switch(VALUES.get(RANDOM.nextInt(SIZE))) 
        {
            case RED: return Color.RED; 
            case GREEN: return Color.GREEN; 
            case BLUE: return Color.BLUE; 
            case YELLOW: return Color.YELLOW; 
            case ORANGE: return Color.ORANGE; 
            default: return Color.BLACK;
        }
    }
    
    void paintCar (){
        Rectangle newCar = new Rectangle(xPos, yPos, HEIGHT, WIDTH);
        newCar.setFill(randomColor());
    }

    void carInfo(int carNumber){
        CalculateCarInfoTask task = new CalculateCarInfoTask(this, carNumber);
        Thread th = new Thread(task);
        th.setDaemon(true);
        th.start();
    }
}
 