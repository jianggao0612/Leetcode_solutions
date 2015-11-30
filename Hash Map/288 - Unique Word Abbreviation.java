/**
 * Unique Word Abbreviation
 *
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
 * A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 */
public class ValidWordAbbr {
    
    Map<String, String> wordMap;
    
    public ValidWordAbbr(String[] dictionary) {
        
        wordMap = new HashMap<String, String>();

        if (dictionary.length < 1) {
            return;
        }
        
        for (String word: dictionary) {
            String abbr = getAbbr(word);
            if (wordMap.containsKey(abbr)) {
                if (!wordMap.get(abbr).equals(word)) {
                    wordMap.put(abbr, " ");
                } 
            } else {
                wordMap.put(abbr,word);
            }
        }
        
    }

    public boolean isUnique(String word) {
        
        if (!wordMap.containsKey(getAbbr(word))) {
            return true;
        } else if (word.equals(wordMap.get(getAbbr(word)))) {
            return true;
        }
        
        return false;
    }
    
    public String getAbbr(String word) {
        
        if (word.length() < 2) {
            return word;
        } else {
            return word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length() - 1);
        }
        
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");