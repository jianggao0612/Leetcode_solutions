/**
 * Bulls and Cows
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each 
 * time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and 
 * position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use 
 * successive guesses and hints to eventually derive the secret number.
 *
 * For example:
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 *
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. 
 * In the above example, your function should return "1A3B".
 *
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 */
public class Solution {
    public String getHint(String secret, String guess) {
        
        // corner case
        if ((secret.length() == 0) || (guess.length() == 0) || (secret.length() != guess.length())) {
            return null;
        }
        
        // Two array store the digits and their corresponding frequencies in the two strings
        int[] secretArray = new int[10];
        int[] guessArray = new int[10];

        // initialization
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < secret.length(); i++) {

            secretArray[secret.charAt(i) - '0']++; // update the secret digits array

            /*
             * Go through the two strings and compare
             */
            if (secret.charAt(i) == guess.charAt(i)) {
            	// if the same digit apprears in the same postion, mark down the frequency in secret digits array to avoid duplicate computation in cows
                secretArray[secret.charAt(i) - '0']--;
                // meets the requirements for bulls
                bulls++;
            } else {
            	// update the guess digits array
                guessArray[guess.charAt(i) - '0']++;
            }
        }
        
        // go over the two arrays to calculate cows
        for (int i = 0; i < 10; i++) {
        	// use the minimun number of the same digits in the two array to calculate cows
            cows += Math.min(secretArray[i], guessArray[i]);
        }
        
        return "" + bulls + "A" + cows + "B";
        
        
    }
}