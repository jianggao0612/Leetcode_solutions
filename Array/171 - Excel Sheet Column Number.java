/**
 * Excel Sheet Column Number
 *
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *    A -> 1
 *    B -> 2
 *    C -> 3
 *    ...
 *    Z -> 26
 *    AA -> 27
 *    AB -> 28
 */
 public class Solution {
    public int titleToNumber(String s) {

        // corner case
        if (s == null || s.length() == 0) {
            return 0;
        }

        int column = 0;
        int length = s.length();
        char[] charArray = s.toCharArray();

        for (int i = length - 1; i >= 0; i--) {
            column += (charArray[i] - 'A' + 1) * Math.pow(26, length - 1 - i);
        }

        return column;

    }
}
