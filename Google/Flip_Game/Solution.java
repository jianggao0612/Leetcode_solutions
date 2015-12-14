public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        ArrayList<String> result = new ArrayList<String>();
        
        int length = s.length();
        if(length == 1) {
            return result;
        }
        
        for(int i = 0; i <length - 1; i++) {
            if(s.substring(i,i+2).equals("++")) {
                result.add(s.substring(0,i) + "--" + s.substring(i+2));
            }
        }
        
        return result;
    }
}