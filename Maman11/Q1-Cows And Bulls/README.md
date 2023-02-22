![alt text](https://repository-images.githubusercontent.com/558048734/9675e878-71d3-4328-9108-5658ed0e69de)

# Bulls and Cows
This project is a simple implementation of the Bulls and Cows game. The game generates a 4-digit number, and the player must guess this number. After each guess, the game provides feedback to the player about the number of bulls and cows in their guess. A "bull" means that the player has guessed a digit that is both in the correct position and value in the target number. A "cow" means that the player has guessed a digit that is in the target number, but not in the correct position.

## Code Structure
The code is structured in two classes:

- `Main:` The main class of the game in which the program runs, performs input and output operations - interaction with the user.
- `GameLogic:` The logic department of the game, in which there are methods for checking the correctness of the input, drawing a number, updating the history of stamps and vulnerabilities... these methods are called the sorter during the running of the program.
- `GameHistory` Records the user attempts and saves them to show the result.

## Running the Game
To run the game, simply run the Main class. The program will ask the player to enter a 4-digit number, and the player must input their guess. If the input is invalid (not a 4-digit number or contains non-numeric characters), the game will show an error message and ask the player to try again. If the input is valid, the game will provide feedback about the number of bulls and cows in the player's guess. The game will continue until the player guesses the correct number, at which point the game will end and the player will be given the option to play again or quit.
