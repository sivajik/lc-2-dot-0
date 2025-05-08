package com.lc2dot0.topinterview150.stack.medium;

import java.util.Stack;

public class Prob150_EvalReversePolish {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}) == 9);
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}) == 6);
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}) == 22);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (isOperator(s)) {
                Integer top1 = stack.pop();
                Integer top2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(top2 + top1);
                        break;
                    case "-":
                        stack.push(top2 - top1);
                        break;
                    case "*":
                        stack.push(top2 * top1);
                        break;
                    case "/":
                        stack.push(top2 / top1);
                        break;
                }
            } else if (isDigit(s)) {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") ||
                s.equals("-") ||
                s.equals("*") ||
                s.equals("/");
    }

    private static boolean isDigit(String s) {
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
