package com.greatlearning.model;

import java.util.*;
public class Main {
    static boolean CheckBracketBalance(String Brackets) {

        Stack<Character> stack = new Stack<>();


        for (int i = 0; i < Brackets.length(); i++) {
            char expression = Brackets.charAt(i);

            if (expression == '(' || expression == '[' || expression == '{') {
                stack.push(expression);
                continue;
            }

            if (stack.isEmpty()) {
            return false;
        }
            char check;
            switch (expression) {

                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
	// write your code here
        String Brackets = "([[{}]]))";
        boolean result;
        result = CheckBracketBalance(Brackets);

        if(result) {
            System.out.println("The entered String has Balanced Brackets");
        }
        else {
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }
    }
}
