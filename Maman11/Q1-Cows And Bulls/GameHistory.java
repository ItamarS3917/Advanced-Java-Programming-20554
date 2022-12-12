import javax.swing.*;

/*
 * This Class save the player attempts history and print the data into the screen with the game info
 **/
public class GameHistory {
    private int attemptsCounter;

    public GameHistory() {
        this.attemptsCounter = 0;
    }

    public String addHistory(int [] playerResult, String playerGuess) {
        String screenOutput = "";
        if(playerResult[0] >= 0 || playerResult[1] >= 0) {
            this.attemptsCounter += 1;
            screenOutput =attemptsCounter+".  Your number: "+playerGuess+"      Cows: "+playerResult[0]+ "   Bulls: "+playerResult[1]+"\n";
        }
        else if(playerResult[0] == -1) {// the user enter not a valid number
            JOptionPane.showMessageDialog(null, "You entered wrong value. try again.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return "";
        }
        else if(playerResult[0] == -2) {//the user entered the same digit twice or more
            JOptionPane.showMessageDialog(null, "You entered the same digit twice or more. try again.", "",
                    JOptionPane.INFORMATION_MESSAGE);
            return "";
        }
        return screenOutput;
    }

    /*
    return the attempts number
     */
    public int getAttemptsCount() {
        return this.attemptsCounter;
    }
    /*
     * reset the attempts counter to 0
     */
    public void resetAttemptsCounter() {
        this.attemptsCounter = 0;
    }
}
