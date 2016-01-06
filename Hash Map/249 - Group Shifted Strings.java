/**
 * Group Shifted Strings
 *
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 * Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 *
 * [
 *  ["abc","bcd","xyz"],
 *  ["az","ba"],
 *  ["acef"],
 *  ["a","z"]
 * ]
 ***********************************************Idea****************************************************************************
 * Use a string to represent the gap between each two characters in a string, and then use the string as a key to group strings
 *******************************************************************************************************************************
 */
public class Solution {
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        Arrays.sort(strings);

        for (String str: strings) {

            String diff = "";

            for (int i = 0; i < str.length() - 1; i++) {
                diff += Integer.toString(((str.charAt(i + 1) - str.charAt(i)) + 26) % 26); // represent the gaps of each pair of two characters
            }

            if (!map.containsKey(diff)) {
                map.put(diff, new ArrayList<String>());
            }

            map.get(diff).add(str);
        }

        return new ArrayList<List<String>>(map.values());


    }

  }
