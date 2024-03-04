package finalproject;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class ButtonMenu extends HBox {
    private ToolBar buttons;
    private Button stop;
    private Button start;
    private Button pause;
    private ContentDisplay CONTENT = ContentDisplay.GRAPHIC_ONLY;
    

    public ButtonMenu(){
        buildUI();
    }

    private void buildUI() {
        pause = new Button("Pause");
        pause.setPrefWidth(100);
        pause.setPrefHeight(50);
        // pause = createButton("Pause","pause-button-red-icon.png" );
        // pause.setContentDisplay(CONTENT);
        pause.setDisable(true);
        // start = createButton("Start", "play-button-green-icon.png");
        start = new Button("Start");
        start.setPrefWidth(100);
        start.setPrefHeight(50);
        // start.setContentDisplay(CONTENT);
        // stop = createButton("Stop", "stop-button-red-icon.png");
        stop = new Button("Stop");
        stop.setPrefWidth(100);
        stop.setPrefHeight(50);
        // stop.setContentDisplay(CONTENT);
        stop.setDisable(true);
        final Pane leftSpacer = new Pane();
        HBox.setHgrow(
                leftSpacer,
                Priority.SOMETIMES
        );
        final Pane leftOutside = new Pane();
        HBox.setHgrow(
                leftOutside,
                Priority.SOMETIMES
        );

        final Pane rightSpacer = new Pane();
        HBox.setHgrow(
                rightSpacer,
                Priority.SOMETIMES
        );
        final Pane rightOutside = new Pane();
        HBox.setHgrow(
            rightOutside,
                Priority.SOMETIMES
        );
        buttons = new ToolBar(leftOutside, start, leftSpacer, pause, rightSpacer, stop, rightOutside);
        getChildren().add(this.buttons);
        buttons.setPrefHeight(100);
        HBox.setHgrow(this.buttons, Priority.ALWAYS);
    } 

    //implement button icons
    public Button createButton(String text, String file){
        String path = "\\src\\main\\resources\\";
        Image img = new Image(path + file);
        ImageView view = new ImageView(img);
        view.setFitHeight(25);
        view.setFitWidth(25);
        Button button = new Button(text, view);
        return button;
    }
}

