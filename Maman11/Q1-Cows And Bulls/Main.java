import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CowsAndBulls game = new CowsAndBulls();

        GameHistory gameHistory = new GameHistory();
        String history = "";//holds the player attempts history
        String playerGuess;//holds the player guess
        int [] playerRes;//array of size 2 to holds the number of "Cows & Bulls"
        boolean game_is_on = true;//flag while the user didn't found the number keep playing

        while(game_is_on) {
            playerGuess = JOptionPane.showInputDialog("Please enter 4 digit number: \n" + history+"\n");
            playerRes = game.cowsAndBulls(playerGuess, game.getComputerNumber());
            history += gameHistory.addHistory(playerRes, playerGuess);
            if(playerRes[1] == 4){ //The player guessed the number
                JOptionPane.showMessageDialog(null, "Congratulations! You found the number after "+gameHistory.getAttemptsCount()+" attempts", "NICE!!",
                        JOptionPane.PLAIN_MESSAGE);
                int option = JOptionPane.showConfirmDialog(null,
                        "press Yes to restart the game, No to quit","" , JOptionPane.YES_NO_OPTION);
                if(option == 0) {// if the user want to play another round
                    game.reset();
                    history = "";
                    gameHistory.resetAttemptsCounter();
                }
                else if(option == 1) {
                    game_is_on = false;
                    JOptionPane.showMessageDialog(null, "Thank you for playing this amazing game!!", "Thank You!!",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }

}
