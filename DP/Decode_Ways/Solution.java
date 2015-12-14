/*
 * for each pos, there are two possiblities:
 * 1. decode it with previous one
 * 2. decode a single char
 * 
 * 0 should be considered... A lot of corner cases
 */

public class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) {
            return 0;
        }
        
        if(s.length() == 1) {
            if(s.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        }
        
        int[] array = new int[s.length()];
        array[0] = s.charAt(0) == '0'?0:1;
        
        if(array[0] == 0) {
            return 0;
        }
        
        if(checkLetter(s.charAt(0), s.charAt(1))) {
            if(s.charAt(1) != '0') {
                array[1] = array[0]+1;
            } else {
                array[1] = array[0];
            }
        } else {
            if(s.charAt(1) == '0') {
                return 0;
            }
            array[1] = array[0];
        }
        
        for(int i = 2; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(checkLetter(s.charAt(i-1), s.charAt(i))) {
                    array[i] = array[i-2];
                } else {
                    return 0;
                }
            } else {
                if(checkLetter(s.charAt(i-1), s.charAt(i))) {
                    array[i] = array[i-2] + array[i-1];
                } else {
                    array[i] = array[i-1];
                }
            }
        }
        
        return array[s.length()-1];
    }
    
    private boolean checkLetter(char a, char b) {
        String numStr = a + "" + b;
        // System.out.println("check num:"+numStr);
        int num = Integer.parseInt(numStr);
        // System.out.println("boolean"+(num <= 26 && num >= 1 && a != '0'));
        return num <= 26 && num >= 1 && a != '0';
    }
}