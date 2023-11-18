package main.java.prob1;

import java.util.*;

public class NumPuzzle {

    public static String getInput() {

        Scanner sc = new Scanner(System.in);

        System.out.println("교환할 두 숫자를 입력>");
        return sc.nextLine();
    }

    public static boolean checkSpaceRule(String token, int index) {

        if (index == 0) {
            if (token.charAt(0) == ' ' || token.charAt(token.length() - 1) == ' ') {
                return false;
            }
        } else {
            if (token.length() > 1) {
                if (token.charAt(0) == ' ' && token.charAt(1) == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkNumericRule(String token) {

        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean checkRangeRule(int number) {

        if (number < 1 || number > 8) {
            return false;
        }

        return true;
    }

    public static boolean isInputValid(String input) {

        String[] tokens = input.split(",");
        if (tokens.length != 2) {
            return false;
        }

        for (int i = 0; i < 2; i++) {
            String token = tokens[i];
            if (!checkSpaceRule(token, i) || !checkNumericRule(token.trim())
                    || !checkRangeRule(Integer.parseInt(token.trim()))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {


    }
}
