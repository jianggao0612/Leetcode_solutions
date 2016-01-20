/**
 *
 * Flip Game
 *
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * For example, given s = "++++", after one move, it may become one of the following states:
 *
 * [
 *  "--++",
 *  "+--+",
 *  "++--"
 * ]
 * If there is no valid move, return an empty list [].
 */
 public class Solution {
    public List<String> generatePossibleNextMoves(String s) {

        List<String> result = new ArrayList<String>();

        // corner case
        if (s == null || s.length() <= 1) {
            return result;
        }

        int length = s.length();
        char[] chars = s.toCharArray();
        char[] flipArray = new char[length];
        for (int i = 0; i < length - 1; i++) {
            if (chars[i] == '+' && chars[i + 1] == '+') {
                System.arraycopy(chars, 0, flipArray, 0, i);
                flipArray[i] = '-';
                flipArray[i + 1] = '-';
                System.arraycopy(chars, i + 2, flipArray, i + 2, length - (i + 2));
                result.add(new String(flipArray));
            }
        }

        return result;
     }
}
