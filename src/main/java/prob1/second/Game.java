package prob1.second;

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
}