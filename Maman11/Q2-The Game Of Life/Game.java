/*This class is responsible for the functions that we will use in the ProjectController class of the game.*/

import java.util.Random;

public class Game {
    private static boolean[][] gameMatrix;

    private int matrixHeight;
    private int matrixWidth;

    /*
     * Constructor for the game.
     * @param int height The matrix height.
     * @param int width The matrix width.
     **/

    public Game(int matHeight, int matWidth) {
        matrixHeight = matHeight;
        matrixWidth = matWidth;
        //initializing an empty matrix.
        this.gameMatrix = new boolean[matrixHeight][matrixWidth];

    }

    // get the matrix
    public boolean[][] getMatrix() {
        return gameMatrix;
    }

    /*
     * This method generates random matrix cells to be filled with "lives"
     * each cell has the probability of 50% to be alive.
     **/
    public void newMatrix() {
        final int PROBABILITY_BOUND = 2; // use this bound to generate random number
        Random rand = new Random();
        // loop through all the matrix cells and if the random number we get is 0 check the cell as alive.
        for (int i = 0; i < this.matrixHeight; i++)
            for (int j = 0; j < this.matrixWidth; j++)
                if (rand.nextInt(PROBABILITY_BOUND) == 0) {
                    gameMatrix[i][j] = true;
                }
    }

    // updates the matrix as defined by Conway's Game of Life's game rules.
    public void updateNextGenerationLives() {
        boolean[][] nextGenMatrix = new boolean[matrixHeight][matrixWidth];
        // for each cell in the matrix check the neighbors status
        for (int i = 0; i < matrixHeight; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                int neighborsLives = countLiveNeighbors(i, j);
                if (neighborsLives <= 1 || neighborsLives >= 4) {// false for over population or loneliness
                    nextGenMatrix[i][j] = false;
                } else if (neighborsLives == 3) {//either way the cell going to be true
                    nextGenMatrix[i][j] = true;
                } else// no need to change
                    nextGenMatrix[i][j] = gameMatrix[i][j];
            }
        }
        //update the game matrix
        gameMatrix = nextGenMatrix;
    }


    /*
     * This method gets the cell row and column and checks if this cell has live cells
     * if the rows or columns greater than 0
     * smaller than matrix rows and columns scan this neighbors
     * for example
     * [X][X][X]
     * [X][O][X]
     * [X][X][X]
     * else scan this neighbors.
     * for example
     * [X][X]
     * [O][X]
     * @param cellRow The cell row
     * @param cellColumn The cell column
     * @return The number of live neighbors if the cell has any
     **/
    public int countLiveNeighbors(int cellRow, int cellColumn) {
        int liveNeighbors = 0; //counts the live neighbors
        //initializing where we start and end the loop
        int startingRow = Math.max(0, cellRow - 1);
        int endRow = Math.min(cellRow + 1, gameMatrix.length - 1);
        int startingColumn = Math.max(0, cellColumn - 1);
        int endColumn = Math.min(cellColumn + 1, gameMatrix[0].length - 1);

        for (int i = startingRow; i <= endRow; i++) {
            for (int j = startingColumn; j <= endColumn; j++) {
                if (gameMatrix[i][j] && (cellRow != i || cellColumn != j))
                    liveNeighbors += 1;
            }
        }
        return liveNeighbors;
    }


}