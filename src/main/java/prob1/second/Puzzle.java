package prob1.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 게임에서 사용할 퍼즐 클래스
 */
public class Puzzle {

    private List<Integer> puzzle; // 퍼즐 List

    /**
     * 퍼즐 생성자
     * 퍼즐을 섞어서 멤버 puzzle에 세팅한다.
     *
     * @param mixCount 섞을 횟수
     */
    Puzzle(int mixCount) {

        List<Integer> puzzle = new ArrayList<>();

        for (int i = 0; i < 16; i++) {
            puzzle.add(i + 1); // 퍼즐 빈 공간은 16으로 세팅
        }

        Random random = new Random();

        for (int i = 0; i < mixCount; i++) {

            // 1~15 인덱스 중 랜덤하게 두 값을 뽑기
            int start = random.nextInt(7) + 1; // 1 ~ 7
            int end = random.nextInt(8) + 8; // 8 ~ 15


            // 뽑힌 두 인덱스 사이의 값들을 퍼즐의 맨 앞에 추가
            List<Integer> sub = new ArrayList(puzzle.subList(start, end + 1));
            puzzle.removeAll(sub);
            puzzle.addAll(0, sub);
        }

        this.puzzle = puzzle;
    }

    /**
     * 퍼즐을 반환 함수
     *
     * @return 현재 퍼즐 List
     */
    public List<Integer> getPuzzle() {
        return this.puzzle;
    }
}