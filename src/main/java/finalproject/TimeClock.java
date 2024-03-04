package finalproject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class TimeClock extends HBox{

    public TimeClock(){
        buildUI();
    }

    private void buildUI() {
        Label label1 = new Label("Current Time : ");
        Label timeLabel  = new Label();
        timeLabel.setStyle("-fx-border-thickness: 4px; -fx-border-style: solid; -fx-background-color: transparent");
        label1.setStyle("-fx-font-size: 50px; -fx-font-weight: bold");
        timeLabel.setStyle("-fx-font-size: 50px; -fx-font-weight: bold" );
        final Pane leftSpacer = new Pane();
        HBox.setHgrow(
                leftSpacer,
                Priority.SOMETIMES
        );
        final Pane rightSpacer = new Pane();
        HBox.setHgrow(
                rightSpacer,
                Priority.SOMETIMES
        );
        AnimationTimer clock= new AnimationTimer(){

            @Override
            public void handle(long arg0) {
                timeLabel.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            }
  
        };
        this.getChildren().addAll(leftSpacer, label1, timeLabel, rightSpacer);
        HBox.setHgrow(this, Priority.ALWAYS);
        clock.start();

    }
}
