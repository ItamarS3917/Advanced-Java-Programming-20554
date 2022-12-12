import java.util.Random;
/*
Cows and bulls class
generates random number and checks if the player entered valid number and guessed the right number
 */
public class CowsAndBulls {

    private String computerNumber;

    private final int NUM_OF_DIGITS = 4;

    /*
    Construct a random number by calling the generateRandomNumber() method
     */
    public CowsAndBulls() {
        this.computerNumber = generateRandomNumber();
    }

    /*
     * Generates valid random computerNumber
     */
    private String generateRandomNumber() {
        Random generator = new Random();
        boolean equal_digits = true;//flag when all digits are not equal return the number
        String numAsString = "";//return this String
        int num1, num2, num3, num4 = 0;// 4 digits of computer number
        while(equal_digits) {
            num1 = generator.nextInt(10);
            num2 = generator.nextInt(10);
            num3 = generator.nextInt(10);
            num4 = generator.nextInt(10);
            numAsString = convertIntToString(num1, num2,  num3, num4);
            if(allDigitsAreDifferent(numAsString)) { //the number is valid
                equal_digits = false;
            }
        }
        return numAsString;
    }

    /*
    This method gets a string(number) and check if all the digits are different
    The method gets String that has only 4 digits.
    @return true if all 4 digits are different otherwise false
     */
    private boolean allDigitsAreDifferent(String number) {
        return number.charAt(0) != number.charAt(1) && number.charAt(0) != number.charAt(2) && number.charAt(0) != number.charAt(3)
                && number.charAt(1) != number.charAt(2) && number.charAt(1) != number.charAt(3) && number.charAt(2) != number.charAt(3);
    }

    /*
    The game method.
    gets a string from the player and checks if the player found the right numbers.
    return array[1] that holds the result of the game.
    if the user didn't guess any number don't change the array return {0, 0}
    if the user entered characters that are not a number return{-1, -1}
    if the user entered the same digits twice or more return {-2, -2}
    else return {cows, bulls}
     */
    public int [] cowsAndBulls(String playerNumber, String randomNumber) {
        int [] resultArr = {0, 0}; //resultArr[0] holds cows, resultArr[1] bulls

        //if the player entered characters like "a" or special characters
        if(!playerNumber.matches("[0-9]+") || playerNumber.length() != NUM_OF_DIGITS) {
            resultArr[0] = -1;
            resultArr[1] = -1;
            return resultArr;
        }
        //if the user entered the same number twice or more
        else if(!allDigitsAreDifferent(playerNumber)) {
            resultArr[0] = -2;
            resultArr[1] = -2;
            return resultArr;
        }
        //if the number is valid check for matching numbers
        for (int i = 0; i < NUM_OF_DIGITS; i++) {
            for(int j = 0; j < NUM_OF_DIGITS; j++) {
                if(randomNumber.charAt(i) == playerNumber.charAt(j)) {
                    if(i != j) { //cows
                        resultArr[0]++;
                    }
                    else { //bulls
                        resultArr[1]++;
                    }
                }
            }
        }
        return resultArr;
    }

    /*
    This method gets 4 integers and converts the numbers into a String.
     */
    public String convertIntToString(int num1, int num2, int num3, int num4) {
        String first = Integer.toString(num1);
        String second = Integer.toString(num2);
        String third = Integer.toString(num3);
        String fourth = Integer.toString(num4);
        return first + second + third + fourth;//return's the numbers as a single string
    }

    public String getComputerNumber() {
        return this.computerNumber;
    }

    public void reset() {
        this.computerNumber = generateRandomNumber();
    }
}
