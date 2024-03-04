package finalproject;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainView {
    private Stage window;
    private BorderPane root;
    private Scene scene;
    private Stoplight light; 
    private ButtonMenu buttons;
    private TimeClock clock;
    private HBox center;
    private int totalIntersections = 1;
    private int totalRoads= 0;

    public MainView(Stage stage){
        this.window = stage;
        buildView();
    }

    private void buildView(){
        root = new BorderPane();

        light = new Stoplight();
        buttons = new ButtonMenu();
        clock = new TimeClock();

        //set center pane
        center = new HBox();
        root.setCenter(center);
        addIntersection(center);

        //top of window
        HBox top = new HBox();
        top.setPrefHeight(100);
        top.setStyle("-fx-background-color: #bebebe;");
        Button addCar = new Button("New Car");
        addCar.setPrefWidth(100);
        addCar.setPrefHeight(35);
        Button addIntersection = new Button("Add");
        addIntersection.setPrefWidth(100);
        addIntersection.setPrefHeight(35);
        
        addIntersection.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                if(totalIntersections<4){
                    totalIntersections++;
                    addIntersection(center);
                    System.out.println("New intersection added");
                }else {
                    Stage stage = (Stage) window.getScene().getWindow();
                    AlertType type = AlertType.WARNING;
                    Alert alert= new Alert(type, "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.initOwner(stage);

                    alert.getDialogPane().setContentText("Too many open simulations. Cannot open more");
                    alert.getDialogPane().setHeaderText("Warning!");
                    alert.showAndWait();
                }
            }
        });
        top.getChildren().addAll(clock, addIntersection, addCar);
        top.setAlignment(Pos.CENTER);
        root.setTop(top);

        //bottom of window
        root.setBottom(buttons); 

        scene = new Scene(root, 2000, 1000);
        window.setTitle("Traffic Control Applet");
        window.setScene(scene);
        window.show();
    }

    public void addIntersection(HBox center){
        StackPane newStack = new StackPane();
        
        

        newStack.setPrefWidth(2000);
        newStack.setPrefHeight(center.getHeight());
        newStack.setStyle("-fx-border-color: black; -fx-border-style: solid");
        Stoplight newLight = new Stoplight();
        newLight.invokeStoplightTask();
        Road newRoad = new Road(totalRoads++,0, (int)(newStack.getHeight()/2)+250);
        StackPane.setMargin(newRoad, new Insets(50,50,50,50));
        newStack.getChildren().addAll(newLight, newRoad );
        StackPane.setAlignment(newLight, Pos.TOP_LEFT);
        StackPane.setAlignment(newRoad, Pos.CENTER);
        center.getChildren().add(newStack);
    }
}

