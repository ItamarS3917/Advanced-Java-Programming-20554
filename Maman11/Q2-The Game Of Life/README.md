<img src="https://camo.githubusercontent.com/3025b261ad9482b90e50c595a1a76aba9cc84e5a727ed9fb90d0eca84524ce9c/68747470733a2f2f7261772e6769746875622e636f6d2f776f6f64727566772f43476f4c2f6d61737465722f6578616d706c65732f63676f6c2e6769663f7261773d74727565" width="350" height="350"/>

# Conway's Game of Life
Conway's Game of Life is a cellular automaton game that was invented by mathematician John Conway in 1970. The game consists of a two-dimensional grid of cells that can be in one of two states - alive or dead. The state of each cell depends on the states of its neighbors. The game evolves over time, with each new generation of cells being determined by the previous generation according to some predefined set of rules.

## Requirements
- Java Development Kit (JDK) 8 or higher.
- JavaFX 8 or higher.

## Usage
After running the project, you will see a window with a grid of cells. The cells are initially randomly generated to be either alive or dead. You can click on the "Next Generation" button to advance to the next generation of the game. The state of each cell in the next generation will be determined by the state of its neighbors in the current generation, according to the following rules:

- Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
- Any live cell with two or three live neighbors lives on to the next generation.
- Any live cell with more than three live neighbors dies, as if by overpopulation.
- Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

## Architecture
The project consists of two classes:

`GameController:` The controller class for the game. This class is responsible for managing the game's graphical user interface, initializing the game, and updating the game's state according to user input.

`Game:` The model class for the game. This class is responsible for representing the game's state, updating the game's state according to the rules of the game, and returning the state of the game to the controller class for display.
