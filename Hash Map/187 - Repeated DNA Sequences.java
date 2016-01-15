/**
 * Repeated DNA Sequences
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 */
 public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        // corner case
        if ((s == null) || (s.length() < 10)) {
            return new ArrayList();
        }

        Set<String> set = new HashSet<String>();
        Set<String> resultSet = new HashSet<String>();

        for (int i = 0; i <= s.length() - 10; i++) {
            String subString = s.substring(i, i + 10);
            if (set.contains(subString)) {
                resultSet.add(subString);
            } else {
                set.add(subString);
            }
        }

        List<String> result = new ArrayList<String>(resultSet);
        return result;

    }
}
