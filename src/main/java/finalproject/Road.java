package finalproject;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Road extends BorderPane
{
    protected Rectangle road;
    private static final Random RANDOM = new Random();
    protected final int LANE_WIDTH = 200;
    double laneLength = 2000;
    final int ROAD_ID;
    final int startX; 
    final int startY;
    
    public Road(int id, int xPos, int yPos) {
        this.ROAD_ID = id;
        this.startX = xPos;
        this.startY = yPos;
        buildComponent();
    }

    private void buildComponent() {
        //car info pane
        VBox carInfo= new VBox();
        carInfo.setStyle("-fx-border-style: solid; -fx-background-color: lightgrey;");
        carInfo.setStyle("-fx-font-size: 10px; -fx-font-weight: bold");
        Label carSpeed = new Label("Car Speed: ");
        Label carPos = new Label("Car X/Y: ");
        carInfo.getChildren().addAll(carSpeed, carPos);

        //road pane
        road = new Rectangle(startX, startY, laneLength, LANE_WIDTH);
        road.setFill(Color.BLACK);
        road.setStroke(Color.WHITE);

        setStyle("-fx-border-style: solid");
        getChildren().addAll(road, carInfo);
        setBottom(carInfo);

        
    }
    public void addCar(){
        Vehicle vehicle = new Vehicle(10, LANE_WIDTH/4, RANDOM.nextInt(60));
        
    }

}
