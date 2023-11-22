package prob1.second;

import java.util.List;
import java.util.Scanner;

public class Game {

    /**
     * 사용자로부터 숫자를 입력받는 함수
     * 입력한 라인 전체를 읽어들임.
     *
     * @return 사용자가 입력한 문자열
     */
    public static String getInput() {

        System.out.print("숫자 입력> ");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * 사용자가 입력한 값이 정수이며, 정상 범위인지 확인하는 함수
     * 정상이면 정수로 변환하여 반환하고, 비정상이면 0을 반환함.
     *
     * @param input 사용자가 입력한 문자열
     * @return 정상 여부에 따른 정수값
     */
    public static int checkNumericRule(String input) {

        try {
            int num = Integer.parseInt(input);
            return num;
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 해당 번호 퍼즐이 이동할 수 있는지 확인하는 함수
     *
     * @param puzzle 현재 퍼즐 List
     * @param num 사용자가 입력한 퍼즐 번호
     * @return 이동 가능 여부
     */
    public static boolean isMovable(List<Integer> puzzle, int num) {

        int numIndex = puzzle.indexOf(num); // 퍼즐 번호의 인덱스
        int[] targetIndex = {numIndex + 4, numIndex - 4, numIndex + 1, numIndex - 1};

        for (int i : targetIndex) {
            if (i < 0 || i > 15) {
                continue;
            }

            if (puzzle.get(i) == 16) {
                return true;
            }
        }

        return false;
    }

    /**
     * 선택된 번호 퍼즐을 빈 공간으로 이동시키는 함수
     *
     * @param puzzle 현재 퍼즐 List
     * @param target 이동시킬 번호
     * @param emptyIndex 퍼즐의 빈 공간(16) 인덱스
     */
    public static void move(List<Integer> puzzle, int target, int emptyIndex) {

        puzzle.set(puzzle.indexOf(target), 16);
        puzzle.set(emptyIndex, target);
    }
}