/**
 *
 * My Submissions Question
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *    1 -> A
 *    2 -> B
 *    3 -> C
 *    ...
 *    26 -> Z
 *    27 -> AA
 *    28 -> AB
 */
 public class Solution {
    public String convertToTitle(int n) {

        // corner case
        if (n < 1) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        int divider = n;

        while (divider != 0) {
            builder.append((char)('A' + (--divider) % 26));
            divider /= 26;
        }
        

        return builder.length() == 0 ? "A" : builder.reverse().toString();

    }
 }
