package finalproject;

import javafx.concurrent.Task;

public class CalculateCarInfoTask extends Task{
    Vehicle car;
    int carNumber;
    public CalculateCarInfoTask(Vehicle car, int carNumber){
        this.car = car;
        this.carNumber = carNumber;
    }
    @Override
    protected Vehicle call() throws Exception {
        System.out.println("Car "+ carNumber+" : \nSpeed: "+car.getSpeed()+" MPH\n(X,Y) Position: "+car.getX()+","+car.getY());
        return car;
       
    }
    
    
}
