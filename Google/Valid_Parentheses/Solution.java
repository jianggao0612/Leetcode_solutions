/**
 * Use a stack to keep adding and pop pairs. If peek and current cannot pair up, then return false
 */

public class Solution {
    Stack<Character> stack = new Stack<Character>();
    
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        
        for(int i = 0; i < charArray.length; i++) {
            char curChar = charArray[i];
            switch(curChar) {
                case '{': {
                    stack.push(curChar);
                    break;
                }
                case '(': {
                    stack.push(curChar);
                    break;
                }
                case '[': {
                    stack.push(curChar);
                    break;
                }
                case '}': {
                    if(stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                }
                case ')': {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                }
                case ']': {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}