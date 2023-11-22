# 1차원 숫자 퍼즐
<hr>

## 구현 함수

### `String getInput()`
+ 사용자로부터 두 개의 숫자를 입력받습니다.

### `boolean isInputValid(String input)`
+ 사용자가 입력한 문자열이 문제가 없는지 확인합니다.
+ 문자열을 `,`를 기준으로 토큰화 하여 만들어진 배열의 크기가 2일 때만 검사를 진행합니다.<br>(적어도 `,`를 기준으로 두 개의 숫자를 입력 받았음을 확정하기 위해)
+ 검사 과정은 3단계로 나누어 진행됩니다.
  + `boolean checkSpaceRule(String token, int index)`
  + `boolean checkNumericRule(String token)`
  + `boolean checkRangeRule(int number)`
+ 위 함수들에 대해 모두 `true`값이 반환되면 규칙에 문제가 없음을 알 수 있습니다.
  
### `boolean checkSpaceRule(String token, int index)`
+ 공백 규칙을 위반하지 않는지 확인합니다.

### `boolean checkNumericRule(String token)`
+ 숫자만을 입력했는지 확인합니다.

### `boolean checkRangeRule(int number)`
+ 입력된 숫자가 주어진 범위(1~8)에 있는 정수인지 확인합니다.

### `ArrayList<Integer> generatePuzzle()`
+ 1~8의 정수가 랜덤하게 섞인 퍼즐을 생성합니다.

### `void swap(ArrayList<Integer> puzzle, int one, int two)`
+ 퍼즐에서 지정된 두 값의 위치를 서로 교환합니다.

### `int[] extractNumbers(String input)`
+ 입력한 문자열로 부터 정수 두개를 추출해 배열로 반환합니다.

### `void printPuzzleStatus(ArrayList<Integer> puzzle)`
+ 퍼즐의 현재 정렬 상태를 출력합니다.

### `boolean isSorted(ArrayList<Integer> puzzle)`
+ 퍼즐이 오름차순으로 정렬 되었는지 확인합니다.

### `void start(ArrayList<Integer> puzzle)`
+ 퍼즐 게임을 시작합니다.

<hr>

## 주요 알고리즘

### 입력받은 문자열의 규칙 위반 여부 확인
1. 사용자가 입력받은 문자열을 `,`를 기준으로 토큰화 합니다.
   + 토큰화 된 배열의 크기가 2일 때만 규칙검사를 이어서 진행합니다.<br>(적어도 `,`를 기준으로 두 개의 값이 입력 되었음을 확정하기 위해)
2. 분리된 각 토큰(2개)을 주어진 규칙에 따라 검사합니다.
3. 띄어쓰기 확인
   + 첫 번째 토큰
     + 앞/뒤 어디에도 공백이 있으면 안됩니다.<br> ( ⭕️ :  `"1, 2"` )<br> ( ❌ :  `" 1 , 2"`  `" 1, 2"` )
   + 두 번째 토큰
     + 길이가 2 이상일 경우
       + 앞 두 자리가 모두 동시에 공백이 있으면 안됩니다.<br> ( ⭕️ :  `"1, 2"` )<br> ( ❌ :  `"1,  2"` )
     + 길이가 2 미만일 경우
       + 적어도 하나의 문자가 있으므로 문제가 없습니다. (공백 포함)
4. 정수인지 확인
   1. `trim()` 메소드를 이용해 토큰의 공백을 제거합니다.
   2. `Integer.parseInt()` 메소드를 이용해 정수 변환을 시도해<br>예외가 발생하면 정수가 아님을 확인합니다.
5. 범위 확인
   + 정수로 변환된 토큰이 1~8 범위에 있는지 확인합니다.
6. 최종 확인
    + 모든 단계를 통과하면 입력에 문제가 없음을 확정합니다.

<hr>

## 실행 결과
+ 실행 환경 `jdk-11`
+ 실행 화면