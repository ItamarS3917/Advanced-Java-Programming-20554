package com.example.q213trivia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**

 The HelloApplication class extends the javafx.application.Application class and overrides the start method.

 The start method is called when the application is launched and it sets the scene for the application.

 The FXMLLoader is used to load the fxml file "trivia.fxml" and it is set as the root node of the scene.

 The scene is then set on the stage and the stage is shown to the user.

 The main method simply calls the launch method to start the application.
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("trivia.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 750);
        stage.setTitle("TRIVIA GAME");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}