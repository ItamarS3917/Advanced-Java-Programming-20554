import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Canvas canvas;

    private Game gameMatrix;
    private GraphicsContext gc;
    private final int MATRIX_HEIGHT = 10;
    private final int MATRIX_WIDTH = 10;

    @FXML
    private void initialize() {
        gameMatrix = new Game(MATRIX_HEIGHT, MATRIX_WIDTH); //Creates a Matrix for the game
        gameMatrix.newMatrix();//Initializing the matrix
        initMatrix(); //Draw a matrix
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.setLineWidth(0.1);

    }

    /*
    When the user hits the "Next Generation" Button update the game matrix
     */
    @FXML
    private void updateMatrixLives(ActionEvent event) {
        gameMatrix.updateNextGenerationLives();
        initMatrix();
    }

    /*
    Draw a 10X10 Matrix for the game
     */
    private void initMatrix() {
        boolean[][] mat = gameMatrix.getMatrix();
        double canvasWidth = canvas.getWidth();
        double canvasHeight = canvas.getHeight();
        double firstCoor, secondCoor, thirdCoor, fourthCoor;
        gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i = 0; i < MATRIX_HEIGHT; i++) {
            for (int j = 0; j < MATRIX_WIDTH; j++) {
                firstCoor = i / (double) MATRIX_HEIGHT * canvasWidth;
                secondCoor = j / (double) MATRIX_HEIGHT * canvasHeight;
                thirdCoor = canvasWidth / MATRIX_WIDTH;
                fourthCoor = canvasHeight / MATRIX_WIDTH;
                if (mat[i][j]) {
                    gc.fillRect(firstCoor, secondCoor, thirdCoor, fourthCoor);
                }
                gc.strokeRect(firstCoor, secondCoor, thirdCoor, fourthCoor);
            }
        }
    }
}
