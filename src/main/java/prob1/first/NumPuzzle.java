package prob1.first;

import java.util.*;

public class NumPuzzle {

    private static int turn = 0;

    /**
     * 사용자로부터 숫자를 입력받는 함수
     *
     * @return 입력받은 문자열
     */
    public static String getInput() {

        Scanner sc = new Scanner(System.in);

        System.out.println("교환할 두 숫자를 입력>");
        return sc.nextLine();
    }

    /**
     * 입력받은 문자 토큰의 공백 규칙을 확인하는 함수
     *
     * @param token 문자열의 한 토큰
     * @param index 토큰 배열에서의 해당 인덱스
     * @return 규칙이 맞는지에 대한 여부
     */
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

    /**
     * 입력받은 문자 토큰이 정수인지 확인하는 함수
     *
     * @param token 문자열의 한 토큰
     * @return 정수 여부
     */
    public static boolean checkNumericRule(String token) {

        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    /**
     * 입력받은 정수 토큰의 범위가 올바른지 확인하는 함수
     *
     * @param number 정수 토큰
     * @return 범위가 올바른지에 대한 여부
     */
    public static boolean checkRangeRule(int number) {

        if (number < 1 || number > 8) {
            return false;
        }

        return true;
    }

    /**
     * 사용자가 입력받은 문자열이 규칙을 지키는지 확인하는 함수
     * 위 3개의 함수를 통해 순서대로 확인함.
     *
     * @param input 입력받은 문자열
     * @return 규칙이 맞는지에 대한 여부
     */
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

    /**
     * 랜덤 퍼즐을 생성하는 함수
     *
     * @return 생성된 랜덤 퍼즐 List
     */
    public static List<Integer> generatePuzzle() {

        List<Integer> puzzle = new ArrayList<>();

        Random random = new Random();

        while (puzzle.size() != 8) {
            int randomNumber = random.nextInt(8) + 1;
            if (!puzzle.contains(randomNumber)) {
                puzzle.add(randomNumber);
            }
        }

        return puzzle;
    }

    /**
     * 퍼즐에서 임의의 두 값을 서로 교환하는 함수
     *
     * @param puzzle 현재 퍼즐 List
     * @param one 교환 할 첫 번째 퍼즐의 인덱스
     * @param two 교환 할 두 번째 퍼즐의 인덱스
     */
    public static void swap(List<Integer> puzzle, int one, int two) {
        int tmp = puzzle.get(one);
        puzzle.set(one, puzzle.get(two));
        puzzle.set(two, tmp);
    }

    /**
     * 사용자가 입력한 문자열로부터 정수 두개를 추출하는 함수
     * 주어진 규칙에 위반되지 않는 전제가 필요함.
     *
     * @param input 입력받은 문자열
     * @return 정수 두 개를 담은 배열
     */
    public static int[] extractNumbers(String input) {

        String[] tokens = input.split(",");

        int[] numbers = new int[2];
        numbers[0] = Integer.parseInt(tokens[0].trim());
        numbers[1] = Integer.parseInt(tokens[1].trim());

        return numbers;
    }

    /**
     * 현재 퍼즐 상태를 출력하는 함수
     *
     * @param puzzle 현재 퍼즐 List
     */
    public static void printPuzzleStatus(List<Integer> puzzle) {
        System.out.println(puzzle.toString());
    }

    /**
     * 퍼즐이 정상적으로 정렬 되었는지 확인하는 함수
     *
     * @param puzzle 현재 퍼즐 List
     * @return 정렬 여부
     */
    public static boolean isSorted(List<Integer> puzzle) {
        for (int i = 0; i < 8; i++) {
            if (puzzle.get(i) != i + 1) {

                return false;
            }
        }

        return true;
    }

    /**
     * 퍼즐 게임 시작 함수
     *
     * @param puzzle 현재 퍼즐 List
     */
    public static void start(List<Integer> puzzle) {
        while (true) {
            System.out.println("Turn " + ++turn);
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

        List<Integer> puzzle = generatePuzzle();
        System.out.println("간단 숫자 퍼즐");
        start(puzzle);
    }

}
