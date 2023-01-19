import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class CalenderApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Create an FXMLLoader object to load the calender.fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(CalenderApplication.class.getResource("calender.fxml"));

        // Create a Scene object with a width of 650 and a height of 700
        Scene scene = new Scene(fxmlLoader.load(), 650, 700);

        // Set the title of the stage and set the scene
        stage.setTitle("Calendar");
        stage.setScene(scene);

        // Show the stage (window)
        stage.show();
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch();
    }
}
