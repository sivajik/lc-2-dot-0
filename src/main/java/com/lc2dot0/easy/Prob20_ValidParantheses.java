package com.lc2dot0.easy;

import java.util.Stack;

public class Prob20_ValidParantheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(!isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(!isValid("["));
        System.out.println(!isValid("]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char topChar = stack.pop();
                    if (c == ')') {
                        if (topChar != '(') {
                            return false;
                        }
                    } else if (c == ']') {
                        if (topChar != '[') {
                            return false;
                        }
                    } else if (c == '}') {
                        if (topChar != '{') {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
