package main.java.prob1.first;

import java.util.*;

public class NumPuzzle {

    private static int turn = 1;

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

    public static ArrayList<Integer> generatePuzzle() {

        ArrayList<Integer> puzzle = new ArrayList<>();

        Random random = new Random();

        while (puzzle.size() != 8) {
            int randomNumber = random.nextInt(8) + 1;
            if (!puzzle.contains(randomNumber)) {
                puzzle.add(randomNumber);
            }
        }

        return puzzle;
    }

    public static void swap(ArrayList<Integer> puzzle, int one, int two) {
        int tmp = puzzle.get(one);
        puzzle.set(one, puzzle.get(two));
        puzzle.set(two, tmp);
    }

    public static int[] extractNumbers(String input) {

        String[] tokens = input.split(",");

        int[] numbers = new int[2];
        numbers[0] = Integer.parseInt(tokens[0].trim());
        numbers[1] = Integer.parseInt(tokens[1].trim());

        return numbers;
    }

    public static void printPuzzleStatus(ArrayList<Integer> puzzle) {
        System.out.println(puzzle.toString());
    }

    public static boolean isSorted(ArrayList<Integer> puzzle) {
        for (int i = 0; i < 8; i++) {
            if (puzzle.get(i) != i + 1) {

                return false;
            }
        }

        return true;
    }

    public static void start(ArrayList<Integer> puzzle){
        while (true) {
            System.out.println("Turn " + turn++);
            printPuzzleStatus(puzzle);

            while (true) {
                String input = getInput();

                if (isInputValid(input)) {
                    int[] numbers = extractNumbers(input);
                    swap(puzzle, puzzle.indexOf(numbers[0]), puzzle.indexOf(numbers[1]));
                    System.out.println();
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.\n");
                }
            }
            if (isSorted(puzzle)) {
                System.out.println("축하합니다! " + turn + "턴만에 퍼즐을 완성하셨습니다!");
                break;
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> puzzle = generatePuzzle();
        System.out.println("간단 숫자 퍼즐");
        start(puzzle);
    }

}
