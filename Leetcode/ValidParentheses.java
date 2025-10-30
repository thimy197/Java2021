package com.alibou.aws.test;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String test1 = "()[]{}";// true
        String test2 = "([)]"; //false
        String test3 = "(]"; // false
        String test4 = "([])";// true
        System.out.println(new ValidParentheses().isValid(test1));
    }

    public boolean isValid(String s) {
        Stack<Character> openCharStack = new Stack<>();
        for(char charAtIndex : s.toCharArray()){
            //for (int i = 0; i < s.length(); i++){
            //    char charAtIndex = s.charAt(i);
            char closeBracketFromId = getCloseBracket(charAtIndex);
            if (closeBracketFromId != ' '){
                // open
                openCharStack.push(closeBracketFromId);
            } else {
                // close
                if (openCharStack.isEmpty()) return false;
                if (openCharStack.pop() != charAtIndex) return false;
            }
        }
        return openCharStack.isEmpty();
    }
    public char getCloseBracket(char s) {
        // replace Map
        return switch (s) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            default -> ' ';
        };
    }
}
