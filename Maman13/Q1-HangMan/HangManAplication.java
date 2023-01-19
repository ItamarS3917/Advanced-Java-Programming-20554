package com.example.q113hangman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//This class is the entry point of the application and it is responsible for loading the FXML file and setting up the scene.
public class HangManApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader is used to load the FXML file
        FXMLLoader fxmlLoader = new FXMLLoader(HangManApplication.class.getResource("Untitled.fxml"));
        //Creates a new scene with the loaded FXML file and sets the dimensions
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        //Sets the title of the stage
        stage.setTitle("HaNgMaN GAme");
        //Sets the scene of the stage
        stage.setScene(scene);
        //Shows the stage
        stage.show();
    }

    //Main method to launch the application
    public static void main(String[] args) {
        launch();
    }
}
