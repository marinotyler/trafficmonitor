package finalproject;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage window) throws IOException {
        new MainView(window);
    }


    public static void main(String[] args) {
        launch();
    }

}