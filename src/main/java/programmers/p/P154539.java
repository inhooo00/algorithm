package programmers.p;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class P154539 {

    public static void main(String[] args) {
        Solution solution = new P154539().new Solution();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] result = solution.solution(numbers);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Deque<Integer> deque = new ArrayDeque<>();
            int size = numbers.length;
            answer[size - 1] = -1;
            deque.push(numbers[size - 1]); // 시작 저장
            for (int i = size - 2; i >= 0; i--) {
                System.out.println(deque);
                if (numbers[i + 1] > numbers[i]) { // 이전 값이 지금 값보다 크면
                    answer[i] = numbers[i + 1]; // 그대로 저장
                    deque.push(numbers[i + 1]); // 스택에도 저장
                } else { // 바로 이전이 아니면 스택 뒤짐
                    boolean isBig = false;
                    while (!deque.isEmpty()) {
                        int now = deque.peek(); // 지금 스택 값
                        if (now > numbers[i]) { // 지금 스택 값이 더 크면
                            answer[i] = now; // 그대로 저장
                            deque.push(numbers[i]);
                            isBig = true;
                            break;
                        } else {
                            deque.pop();
                        }
                    }
                    if (!isBig) {
                        answer[i] = -1;
                        deque.push(numbers[i]);
                    }
                }
            }
            return answer;
        }
    }
}
