# 15 퍼즐
<hr>

## Puzzle.class
퍼즐 게임에 이용 될 퍼즐과 관련된 클래스입니다.

### `Puzzle(int mixCount)`
+ 퍼즐 섞는 횟수를 매개변수로 받아 랜덤 퍼즐을 만드는 생성자 입니다.

### `List<Integer> getPuzzle()`
+ 멤버변수인 퍼즐 List를 반환합니다.

### `void print()`
+ 퍼즐의 현재 상태를 출력합니다.

### `boolean isSorted()`
+ 퍼즐이 완성(정렬) 되었는지 확인합니다.

### `int getEmptyIndex()`
+ 퍼즐에서 빈 공간에 해당하는 인덱스 값을 반환합니다.

## Game.class
퍼즐 게임 진행과 관련된 클래스 입니다.

### `String getInput()`
+ 사용자로 부터 정수를 입력받습니다.

### `int checkNumericRule(String input)`
+ 사용자가 입력한 문자열이 정수인지 확인합니다.

### `boolean isMovable(List<Integer> puzzle, int num)`
+ 입력한 정수의 퍼즐 번호가 이동 가능한 번호인지 확인합니다.

### `void move(List<Integer> puzzle, int target, int emptyIndex)`
+ 해당 번호의 퍼즐을 빈공간으로 이동시킵니다.
+ 
<hr>

## 실행 결과
+ 실행 환경 `jdk-11`
+ 실행 화면

  <img width="279" alt="스크린샷 2023-11-22 오후 10 49 50" src="https://github.com/sefhuk/masters-practice/assets/13714036/a56e6b95-1c7d-4c94-ad1b-6ad421b2cfa9">
