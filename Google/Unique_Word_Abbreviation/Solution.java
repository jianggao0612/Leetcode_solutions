public class ValidWordAbbr {
    HashMap<String, Integer> abbrMap = new HashMap<String, Integer>();
    HashSet<String> wordBag = new HashSet<String>();
    
    public ValidWordAbbr(String[] dictionary) {
        for(String word:dictionary) {
            
            // Check if already processed same word
            if(wordBag.contains(word)) {
                continue;
            } else {
                wordBag.add(word);
            }
            
            String abbr = getAbbreviation(word);
            
            Integer count = abbrMap.get(abbr);
            if(count == null) {
                abbrMap.put(abbr, 1);
            } else {
                abbrMap.put(abbr, count+1);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = getAbbreviation(word);
        Integer count = abbrMap.get(abbr);
        if(count == null) {
            return true; // never appear or only once
        }
        
        if(count == 1 && wordBag.contains(word)){
            return true; // appear once and it is the original word in the dict
        }
        
        return false; // abbreviation appear multiple times
    }
    
    private String getAbbreviation(String word) {
        int length = word.length();
        if(length <= 2) {
            return word;
        } else {
            return "" + word.charAt(0) + (length - 2) + word.charAt(length-1);
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");